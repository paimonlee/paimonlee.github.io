# 关键字

async、await、asyncio

# 运行一个协程

```python
import asyncio

async def main():
    print('hello')
    await asyncio.sleep(1)
    print('world')

asyncio.run(main())
```

要实际运行一个协程，asyncio 提供了一下几种机制：

- asyncio.run()函数用来运行最高层级的入口点"main()"函数
  
- 对协程执行await。
  
  ```python
  import asyncio
  import time
  
  async def say_after(delay, what):
      await asyncio.sleep(delay)
      print(what)
  
  
  async def main()
      print(f"start as {time.strftime('%X')}")
  
      await say_after(1, 'hello')
      await say_after(2, 'world')
  
      print(f"finished at {time.strftime('%X')}")
  
  asyncio.run(main())
  ```
  
- asyncio.create_task()函数用来并发运行作为asyncio任务的多个协程
  
  ```python
  async def main():
      task1 = asyncio.create_task(
          say_after(1, 'hello'))
  
      task2 = asyncio.create_task(
          say_after(2, 'world'))
  
      print(f"started at {time.strftime('%X')}")
  
      # Wait until both tasks are completed (should take
      # around 2 seconds.)
      await task1
      await task2
  
      print(f"finished at {time.strftime('%X')}")
  ```
  
- asyncio.TaskGroup类提供了create_task()的更现代化的替代。

  ```python
  async def main():
      async with asyncio.TaskGroup() as tg:
          task1 = tg.create_task(
              say_after(1, 'hello'))
  
          task2 = tg.create_task(
              say_after(2, 'world'))
  
          print(f"started at {time.strftime('%X')}")
  
      # The await is implicit when the context manager exits.
  
      print(f"finished at {time.strftime('%X')}")
  ```

# 可等待对象

如果一个对象可以在await语句中使用，那么它就是可等待对象。许多asyncio API都被设计为接受可等待对象

可等待对象有三种主要类型：协程、任务和Future

## 协程

python协程属于可等待对象，因此可以在其他写成中被等待：




```python
import asyncio

async def nested():
    return 42


async def main():
    nested()
    print(await nested())

asyncio.run(main())
```

协程函数：定义形式为async def的函数

协程对象：调用协程函数所返回来的对象



## 任务

任务被用来“并行的”调度协程

当一个协程通过asyncio.create_task()等函数被封装为一个任务，该协程会被自动调度执行：

```python
import asyncio

async def nested():
    return 42

async def main():
    task = asyncio.create_task(nested())

    await task


asyncio.run(main())
```



## Futures

Future是一种特殊的低层级可等待对象，表示一个异步操作的最终结果

当一个Future对象被等待，这意味着协程将保持等待直到该Future对象在其他地方操作完毕

在asyncio中需要Future对象以便允许通过async/await使用基于回调的代码



Future对象有时会由库和某些asyncio API暴露给用户，用作可等待对象：

```python
async def main():
    await function_that_returns_a_future_object()

    await asyncio.gether(
        function_that_returns_a_future_object(),
        some_python_coroutine()
    )
```




# 创建任务

# 任务取消

# 任务组

# 休眠

# 并发运行任务

# 主动任务工厂

# 屏蔽取消操作

# 超时

# 简单等待

# 在线程中运行

# 跨线程调度

# 内省

# Task 对象







参考文档：[协程](https://docs.python.org/zh-cn/3/library/asyncio-task.html#coroutine)

