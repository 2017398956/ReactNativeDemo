import React, { Component } from 'react';
import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';

export default class LoginScreen extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <View>
                <TouchableOpacity onPress={() => this.props.navigation.navigate('Home')}>
                    <Text >这是登录页，点击跳转到首页</Text>
                </TouchableOpacity>
            </View>
        )
    }
}