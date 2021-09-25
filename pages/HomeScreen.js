import React, { Component } from 'react';
import { View, Text, Button, TouchableOpacity, StyleSheet } from 'react-native';

export default class HomeScreen extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <View>
        <TouchableOpacity onPress={() => this.props.navigation.navigate('Login')}>
          <Text >这是首页，点击跳转到登陆</Text>
          {/* 在组件中修改使用setOptions */}
          <Button
            title="Update the title"
            onPress={() => this.props.navigation.setOptions({ title: 'Updated!' })}
          />
        </TouchableOpacity>
      </View>
    )
  }
}
