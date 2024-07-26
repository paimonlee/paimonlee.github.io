# 一、Cargo介绍

Cargo是Rust的官方构建工具和包管理器，它的出现极大地提升了Rust的易用性和开发效率。无论是创建新的Rust项目，还是管理项目的依赖，Cargo都能提供极大的便利。

## 1、Cargo安装

在安装Rust时，Cargo也会被一同安装。可以通过在终端中输入以下命令来验证Cargo的安装：

```powershell
cargo --version
```

如果Cargo已经成功安装，该命令将会输出Cargo的版本信息。

## 2、创建Rust项目

创建新的Rust项目是Cargo的一个基本功能。在终端中，运行以下命令：

```powershell
cargo new my_project
```

这将创建一个名为my_project的新项目，其中包含了基本的目录结构和一个简单的"Hello, World!"程序。项目的目录结构如下：

```powershell
my_project
├── Cargo.toml
└── src
    └── main.rs
```

在这个目录结构中，Cargo.toml是项目的配置文件，src目录是源代码的存放位置，main.rs是主程序文件。

Cargo.toml文件是Cargo的配置文件，它定义了项目的名称，版本，作者等信息，以及项目的依赖。一个基本的Cargo.toml文件如下：

```toml
# 定义包的基础信息，如名称，版本和rust版本
[package]
name = "hide"
version = "0.1.0"
edition = "2021"

# 列出项目依赖
[dependencies]

```

```rust
fn main() {
    println!("Hello, World!");
}
```

## 3、编译项目：

编译Rust项目是Cargo的一个基本功能。在终端中，只需运行cargo build命令，Cargo就会编译当前目录下的Rust项目。如果项目有未下载的依赖，Cargo会自动下载并编译它们。

```powershell
cargo build
```

这个命令会在项目的根目录下生成一个名为target的文件夹，其中包含了编译生成的二进制文件和库文件。默认情况下，这个命令会以debug模式进行编译，这意味着编译出的程序包含了调试信息，但是没有进行优化。

如果想要编译出一个用于发布的、优化过的程序，可以使用cargo build --release命令。这个命令会以release模式进行编译，编译出的程序进行了优化，运行速度更快，但是不包含调试信息。

```powershell
cargo build --release
```

在release模式下编译的程序会被放在target/release目录下，而在debug模式下编译的程序则会被放在target/debug目录下。

值得注意的是，编译Rust项目可能需要一些时间，特别是在第一次编译或者在添加了新的依赖之后。但是，Cargo会缓存编译结果，所以在没有修改代码或者依赖的情况下，再次编译会非常快。

## 4、运行项目：

cargo run命令是Cargo的一个重要命令，它的作用是编译并运行Rust项目。这个命令会先检查源代码是否有更改，如果有更改，它会先编译项目，然后运行编译后的程序。

例如，假设有一个名为"my_project"的Rust项目，项目的主程序在"src/main.rs"文件中。在项目的根目录下运行cargo run命令，Cargo会编译并运行这个项目。

```powershell
cargo run
```

如果编译成功，会看到类似以下的输出：

```powershell
   Compiling my_project v0.1.0 (/path/to/my_project)
    Finished dev [unoptimized + debuginfo] target(s) in 0.52s
     Running `target/debug/my_project`
Hello, world!
```

这里，"Hello, world!"是"src/main.rs"文件中程序的输出。

如果源代码没有更改，cargo run命令会直接运行已经编译好的程序，而不会再次编译。这可以节省不必要的编译时间。

cargo run命令还可以接受命令行参数。这些参数会被传递给Rust程序。例如，如果Rust程序需要一个文件名作为参数，可以这样运行：

```powershell
cargo run filename.txt
```

<br/>

这里，"filename.txt"是传递给Rust程序的参数。

## 5、测试项目：

在Rust中，测试是一种非常重要的编程实践，可以帮助开发者确保代码的正确性和稳定性。Cargo提供了一种简单的方式来创建和运行测试。

在Rust中，测试通常写在源代码文件中，位于特殊的#[cfg(test)]模块内，这个模块只在运行cargo test命令时被编译和运行。在这个模块内，每一个以#[test]属性标记的函数都是一个测试函数，Cargo会自动找到并运行这些测试。

例如，以下是一个简单的测试：

```rust
#[cfg(test)]
mod tests {
    #[test]
    fn it_works() {
        assert_eq!(2 + 2, 4);
    }
}
```

在这个例子中，it_works函数是一个测试，它检查2 + 2是否等于4。如果等于4，测试就会通过；如果不等于4，assert_eq!宏会引发一个panic，测试就会失败。

要运行测试，只需要在终端中输入cargo test命令。Cargo会自动找到并运行所有的测试，然后报告测试结果。

```powershell
cargo test
```

除了基本的测试外，Rust还支持更复杂的测试形式，如集成测试、文档测试等。集成测试是在tests目录下的独立文件中编写的，用于测试库的公有接口是否正确。文档测试则是在文档注释中编写的，可以同时作为示例代码和测试。

## 5、更新项目的依赖：

在Rust项目中，依赖是非常重要的一部分。这些依赖，也被称为crate，是Rust的库或者包，可以被其他项目引用和使用。在Rust项目中，所有的依赖都会在Cargo.toml文件中的[dependencies]部分进行声明。

例如，如果项目需要使用到名为"rand"的库，可以在Cargo.toml文件中添加如下内容：

```toml
[dependencies]
rand = "0.8.3"
```

在添加了新的依赖后，运行cargo build命令，Cargo会自动下载并编译所需的依赖。

## 6，生成项目的文档：

生成项目文档是Cargo的一项重要功能。Rust的文档生成工具叫做rustdoc，它可以从Rust源代码中提取文档注释并生成HTML文档。Cargo提供了一个方便的命令cargo doc来调用rustdoc并生成项目的文档。

在Rust中，可以使用三个斜杠///来为函数、结构体、模块等添加文档注释。例如：

在这个例子中，example_function函数有一个文档注释，注释中还包含了一个示例代码块。

```rust
/// 这是一个示例函数。
///
/// # Examples
///
/// ```
/// let result = my_project::example_function(5);
/// assert_eq!(result, 10);
/// ```
pub fn example_function(x: i32) -> i32 {
    x * 2
}
```

当在项目的根目录下运行cargo doc命令时，Cargo会调用rustdoc来为项目生成文档。生成的文档会放在target/doc目录下，每个库都会有一个对应的HTML文件。

```powershell
cargo doc
```

如果想要在生成文档后立即在浏览器中打开它们，可以使用cargo doc --open命令。

在生成的文档中，可以看到所有公共项的文档注释，以及它们的类型签名和源代码。如果文档注释中包含了示例代码块，rustdoc还会自动测试它们，以确保示例代码的正确性。

总的来说，Cargo和rustdoc为Rust项目的文档生成提供了强大的支持，使得在Rust项目中维护和查阅文档变得非常方便。

# 二、Cargo常用命令

以下是Cargo的一些常用命令及其作用，它们可以帮助你更好地管理和构建Rust项目：

|命令|作用|
|--|--|
|cargo new NAME|创建一个新的Rust项目|
|cargo build|编译当前目录下的Rust项目|
|cargo run|编译并运行当前目录下的Rust项目|
|cargo test|运行当前目录下Rust项目的所有测试|
|cargo check|检查代码是否可以编译，但不生成可执行文件|
|cargo clean|清理项目，删除target目录及其内容|
|cargo doc|为当前目录下的Rust项目生成文档|
|cargo update|更新当前目录下Rust项目的所有依赖|
|cargo install NAME|安装指定的crate到系统|
|cargo publish|发布crate到crates.io|
|cargo search TERM|在crates.io上搜索crate|
|cargo bench|运行项目的基准测试|
|cargo login TOKEN|登录到crates.io|
|cargo owner|管理crate的所有者|
|cargo package|打包一个crate以发布|
|cargo uninstall|从系统中卸载一个crate|
|cargo version|显示Cargo的版本信息|

# 三、Cargo常用参数

以下是Cargo命令的一些常用参数及其作用：

|参数|作用|
|--|--|
|--verbose,-v|显示更多的输出信息|
|--release|编译优化后的版本，而不是默认的调试版本|
|--bin NAME|指定要编译或运行的二进制文件|
|--example NAME|编译或运行项目中的示例代码|
|--features "FEATURES"|启用指定的特性|
|--no-default-features|禁用默认的特性|
|--all-features|启用所有的特性|
|--target TRIPLE|指定编译的目标平台|
|--manifest-path PATH|指定Cargo.toml的路径|
|--jobs N|并行运行的编译作业的数量|
|--frozen|禁止更新Cargo.lock或下载依赖|
|--locked|如果Cargo.lock需要更新，则失败|
|--offline|禁止访问网络|
