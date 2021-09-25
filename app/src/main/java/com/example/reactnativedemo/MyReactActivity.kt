package com.example.reactnativedemo

import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent
import com.facebook.react.ReactActivity
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactPackage
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.facebook.react.shell.MainReactPackage
import com.facebook.soloader.SoLoader

class MyReactActivity : ReactActivity(), DefaultHardwareBackBtnHandler {
    private lateinit var mReactRootView: ReactRootView
    private lateinit var mReactInstanceManager: ReactInstanceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SoLoader.init(this, false);
        mReactRootView = ReactRootView(this);
        val useBundle = false
        if (useBundle) {
            val packages = mutableListOf<ReactPackage>()
            packages.add(MainReactPackage())
            // 这里用于加载已打包的 bundle
            mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(application)
                .setCurrentActivity(this)
                // assets 中的 bundle 包名称
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackages(packages)
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        } else {
            mReactInstanceManager =
                (application as MyApplication).reactNativeHost.reactInstanceManager
            // 已在 MyApplication 中实现，也可以在 app 启动后加载以提高 app 打开速度
        }

        // 注意这里的MyReactNativeApp必须对应“index.js”中的
        // “AppRegistry.registerComponent()”的第一个参数
        mReactRootView.startReactApplication(mReactInstanceManager, "ReactNativeDemo", null);
        setContentView(mReactRootView);
    }

    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostPause(this)
        }
    }

    override fun onResume() {
        super.onResume()
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostResume(this, this)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostDestroy(this)
        }
        if (mReactRootView != null) {
            mReactRootView.unmountReactApplication()
        }
    }

    override fun onBackPressed() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_MENU && mReactInstanceManager != null) {
            mReactInstanceManager.showDevOptionsDialog()
            return true
        }
        return super.onKeyUp(keyCode, event)
    }
}