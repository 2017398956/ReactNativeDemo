import 'react-native-gesture-handler';
import React, { Component } from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
//引入页面模块
import LoginScreen from './pages/LoginScreen';
import HomeScreen from './pages/HomeScreen';
import PageA from './pages/PageA';

import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';
import { Colors } from 'react-native/Libraries/NewAppScreen';



class HelloWorld extends React.Component {
  // val Stack = createStackNavigator();
  render() {

    return (

      // <NavigationContainer>
      //   <Stack.Navigator>
      //     <Stack.Screen name="Login" component={LoginScreen} />
      //     <Stack.Screen name="Home" component={HomeScreen} />
      //   </Stack.Navigator>
      // </NavigationContainer>


      <View style={styles.container}>
        <Text style={styles.hello}>跳转到 PageA</Text>
        <Text style={styles.hello}>在已有 Android 项目中集成 ReactNative</Text>
      </View>
    );
  }
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center'
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    color: '#125677',
    backgroundColor: 'white',
    margin: 10
  }
});

const Stack = createStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator
        initialRouteName="Home"     //作为初始化页面、不写的话默认第一个screen为初始化页面
        screenOptions={{                 //用来定制头部信息、根据自己需要更改
          title: '测试标题',
          headerStyle: {
            backgroundColor: '#ee7530'
          },
          headerTintColor: '#fff',
          headerTitleStyle: {
            fontWeight: 'bold',
            fontSize: 20
          }
        }}
        keyboardHandlingEnabled="true"//如果为false，则导航到新屏幕时，屏幕键盘不会自动关闭。默认为true
        // card：使用标准的iOS和Android屏幕过渡。这是默认值.
        // modal：这有两件事：设置headerMode到screen堆栈，除非指定使屏幕从iOS底部的底部滑入，这是一种常见的iOS模式.
        mode="card" // 定义渲染和过渡的样式
        // 指定标题的呈现方式
        // float：渲染停留在顶部的单个标题，并在更改屏幕时进行动画处理。iOS上的常见模式。
        // screen：每个屏幕都有一个附加的标题，标题随屏幕一起淡入和淡出。Android上的常见模式。
        // none ：没有标题。
        headerMode="float"
      >
        <Stack.Screen name="Login" component={LoginScreen} />
        <Stack.Screen name="Home"
          component={HomeScreen} 
          options={{ title: 'My home' }} 
          // 也可以动态获取
          // options={({ route }) => ({ title: route.params.name })}
          />
      </Stack.Navigator>
    </NavigationContainer>
  
  );
}

// export default App;

AppRegistry.registerComponent(
  'ReactNativeDemo',
  () => App
  // 这里也可以使用 HelloWorld
);