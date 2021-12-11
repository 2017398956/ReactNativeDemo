# 由于 RN 升级没调好导致现在不能用了，这个 demo 先到这吧，升级太坑了，想运行的可以用之前的 commit

## 将 ReactNative 接入已有的 Android 项目
	环境：react-native 0.63，windows10 ，android-studio4.1.1

 ### 第一步：首先按照官网 [集成到已有的原生应用](https://reactnative.dev/docs/integration-with-existing-apps) 的方法集成，这里还有一份中文版 [集成到已有的原生应用](https://reactnative.cn/docs/integration-with-existing-apps)
 
 	注意：在集成过程中要注意以下几点。

 1.在执行 yarn add react-native 时可能不止有 react 的 warning ，我们需要把这些包都安装上。![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118133946767.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pdXpodWNlZGVuZ2x1,size_16,color_FFFFFF,t_70#pic_center)
 2. maven 仓库的地址需要修改成下面的样式，不能用文档中的路径（注意路径）
 
	 	allprojects {
	    repositories {
	        maven {
	            // All of React Native (JS, Android binaries) is installed from npm
	            url "../node_modules/react-native/android"
	        }
	        maven {
	            // Android JSC is installed from npm
	            url("../node_modules/jsc-android/dist")
	        }
	       ....
	       }
	    }
	    
 3.将图中的 apply from: file("../node_modules/**** 改成 apply from: file("./node_modules/****；apply from: file("../../node_modules/***** 改成 apply from: file("./../node_modules/***** ；即前面都去掉一个 “.”

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118135553251.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pdXpodWNlZGVuZ2x1,size_16,color_FFFFFF,t_70#pic_center)
### 第二步：在项目根目录下新建 react-native-config.js 文件，将下面的内容复制到文件中
	// 注意：这里只正确配置了 Android 的路径，ios 的请自行配置
	module.exports = {
	  project: {
	    ios: {
	      project: './error.xcworkspace',
	    },
	    android: {
	      sourceDir: './'
	    },
	  },
	  reactNativePath: "./node_modules/react-native",
	  root: "./"
	};

### 第三步：解决 android-studio 中的报错问题
做完前面的两步你会发现 android-studio 会报 找不到 PackageList 的问题（如下图），这是因为这个类是在 react-native 的 gradle 脚本中生成的，所以我们需要先运行下这个脚本。此时你可以使用 yarn android 命令来自动运行相关脚本，但是可能会报 “找不到 react-native 命令" 这个错误； 那么你可以用 npx react-native run-android 试试。至此 问题解决。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118140446154.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pdXpodWNlZGVuZ2x1,size_16,color_FFFFFF,t_70#pic_center)
### 第四步：总结
按照上面的步骤配置完成后，android-studio 就可以正常识别项目了，如果你修改了原生的部分这里是不建议使用 as 的 run 按钮来运行项目的，因为通过 run 按钮的方式有时会中断与 react-native 服务的连接。
这里建议直接在下面的 Terminal 窗口直接输入 npx react-native run-android 运行，这样既兼顾了原生的开发环境又使用了 react-native 的重载机制，不用每次都打 bundle 包（当然发布的时候还是需要打 bundle 包的）。


	