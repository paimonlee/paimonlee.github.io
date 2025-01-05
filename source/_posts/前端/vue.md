---
title: 'vue学习笔记'
date: 2025-01-04 12:00:00
categories:
    - 前端
---

# vue 学习文档


## 组合式API


### setup()
组合式API的入口，以下情况使用
1. 需要在非单文件组件中使用组合式API
2. 需要在基于选项式API的组件中集成基于组合式API的代码时

在setup()函数返回的对象会暴露给模板和组件实例

```vue
<script>
import {ref} from 'vue'

export default {
    setup() {
        const count = ref(0)

        return {
            count
        }
    },

    mounted() {
        cousole.log(this.count)
    }
}

</script>

<template>
    <button @click='count++'>{{ count }}</button>
</template>
```

模板中访问setup返回的ref时，它会自动浅层解包。

setup() 自身不含对组件实例的访问权。setup()应该同步的返回一个对象


#### 访问Props
setup 函数的第一个参数是组件的props

```vue
<script>
export default {
    props: {
        title: String
    },

    setup(props) {
        console.log(props.title)
    }
}
</script>

```
如果解构了props的对象，解构出来的变量将丢失响应性，推荐使用props.xxx来使用参数

或者通过下面方式解构

```vue
<script>
import { toRefs, toRef } from 'vue'

export default {
    setup(props) {
        // 将 `props` 转为一个其中全是 ref 的对象，然后解构
        const { title } = toRefs(props);

        // 将props的单个属性转为一个 ref
        const title = toRef(props, 'title');
    }

}

</script>

```
#### 上下文
传入setup函数第二个参数式一个setup上下文对象，上下文对象暴露了其他一些在setup中可能会用到的指：

```vue
<script>
export default {
    setup(props, context) {
        // 透传 Attributes（非响应式的对象，等价于 $attrs）
        console.log(context.attrs)

        // 插槽（非响应式的对象，等价于 $slots）
        console.log(context.slots)

        // 触发事件（函数，等价于 $emit）
        console.log(context.emit)

        // 暴露公共属性（函数）
        console.log(context.expose)
    }
}
</script>
```

上下文对象是非响应式的，可以安全的解构

```vue
<script>
export default {
    setup (props, {attrs, slots, emit, expose}) {
        
    }
}
</script>
```

attrs 和 slots都是有状态对象，他们会随着组件自身的更新而更新，所以应避免解构。这两个对象是非响应式的，如果需要基于attrs或slots的改变来执行副作用，需要在onBeforeUpdate生命周期钩子中编写相关逻辑

##### 暴露公告属性
expose函数用于显式的限制该组件暴露出的属性，当父组件通过模板引用访问组件的实例时，将仅能访问expose函数暴露出的内容：

```vue
<script>

export default {
    setup(props, { expose }) {
        // 让组件实例处于关闭状态
        expose()

        const publicCount = ref(0)
        const privateCount = ref(0)

        expose({ count: publicCount })
    }
}

</script>
```

#### 渲染函数
setup 也可以返回一个渲染函数

```vue
<script>
import { h, ref } from 'vue'

export default {
    setup() {
        const count = ref(0);
        return () => h('div', count.value)
    }
}
</script>
```

### 响应式api：核心

#### ref()
接受一个内部值，返回一个响应式、可更改的ref对象，对象只有一个属性值.value

#### computed()
接受一个getter函数，返回一个只读的响应式ref对象，通过.value暴露getter函数的返回值

```typescript
const count = ref(1)
const plusOne = computed(() => count.value+1)

console.log(plusOne.value)

plusOne.value++ //报错

```

或者接受一个带有get和set函数的对象来创建一个可写的ref对象
```typescript
const count = ref(1)
const plusOne = computed({
  get: () => count.value + 1,
  set: (val) => {
    count.value = val - 1
  }
})

plusOne.value = 1
console.log(count.value) // 0
```

#### reactive()
返回一个对象的响应式代理


#### readonly()
接受一个对象（不论是响应式还是普通的）或是一个ref,返回一个原值的只读代理

#### watchEffect()
立即运行一个函数，同时响应式的追踪其依赖，并在依赖更改时重新执行

##### watchPostEffect()
watchEffect 的 flush: 'post'

##### watchSyncEffect()
watchEffect 的 flush: 'sync'

#### watch()
监听一个或多个响应式数据源，并在数据源变化的时候调用所给的回调函数

#### onWatcherCleanup()
注册一个清理函数，在当前监听器即将重新运行时执行

### 生命周期钩子
####  vue 生命周期图

![生命周期](./image/lifecycle.png)

####  onMounted()

注册一个回调函数，在组件挂载完成后执行

```vue
<script setup>
onMounted(()=>{
    console.log("Mounted success!")
})
</script>
```

####  onUpdate()

####  onUmounted()

####  onBeforeMount()

####  onBeforeUpdate()


####  onBeforeUnmount()

####  onErrorCaptured()

####  onRenderTracked()

####  onRenderTriggered()

####  onActivated()

####  onDeactivated()

####  onServerPrefetch()

## 选项式API
### 状态选项
#### data
用于声明组件初始响应式状态的函数

函数返回一个普通javascript对象，vue将它转换为响应式对象。组件实例代理了该数据对象上所有的属性，因此this.a等价于this.$data.a

如果一个属性值在一开始还获取不到，应当先用undefined或者null值来占位，让vue知道这个属性存在

以_或$开头的属性将不会被组件实例代理，它们可能和vue的内置属性、api方法冲突，必须以this.$data._property的方式访问

```typescript

export default {
    data() {
        return { a: 1 }
    },
    created(){
        console.log(this.a)
        console.log(this.$data)
    }
}
```

#### props
用于声明一个组件的props

所有的props都需要显式声明。组件props可以通过两种方式声明：
1. 使用字符串数组的简易形式。
2. 使用对象的完整形式。该对象的每个属性键是对应的prop的名称，值则是该prop应具有的类型的构造函数，或是更高级的选项。

在基于对象的语法中，每个prop可以进一步的定义如下选项：

1. type: 
2. default:
3. required:
4. validator:


#### computed

声明要在组件实例上暴露的计算属性

#### methods

声明要混入到组件实例中的方法

#### watch

声明要在数据更改时调用的侦听回调

#### emits

声明由组件出发的自定义事件

#### expose

声明当组件被父组件通过模板引用访问时暴露的公共属性

### 生命周期选项

#### created

#### beforeMount

#### mounted

#### beforeUpdate

#### updated

#### beforeUnmount

#### unmounted

#### errorCaptured

#### renderTracked

#### renderTriggered

#### activated

#### deactivated

#### serverPrefetch 

### 杂项选项

#### name

#### inheritAttrs
用于控制是否启用默认的组件attribute透传行为

#### components
用于注册当前组件实例可用的组件

#### directives

用于注册对当前组件实例可用的指令

### 组件实例

this上暴露的内置属性和方法

#### $data

#### $props

#### $el

#### $options

#### $parent

#### $root

#### $slots

#### $refs

#### $attrs

#### $watch()

#### $emit()

#### $forceUpdate()

#### $nextTick()
