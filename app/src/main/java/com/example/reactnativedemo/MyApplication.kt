package com.example.reactnativedemo

import android.app.Application
import android.content.Context
import com.facebook.react.*
import com.facebook.soloader.SoLoader

class MyApplication : Application(), ReactApplication {

    private val mReactNativeHost = object : ReactNativeHost(this) {
        override fun getUseDeveloperSupport(): Boolean {
            return BuildConfig.DEBUG
        }

        override fun getPackages(): MutableList<ReactPackage> {
            val packages = PackageList(this).packages;
            // Packages that cannot be autolinked yet can be added manually here, for example:
            // packages.add(new MyReactNativePackage());
            // val packages = mutableListOf<ReactPackage>()
            return packages;
        }

        override fun getJSMainModuleName(): String {
            return "index"
        }
    }

    override fun getReactNativeHost(): ReactNativeHost {
        return mReactNativeHost
    }

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, /* native exopackage */ false);
        initializeFlipper(this, reactNativeHost.reactInstanceManager);
    }

    /**
     * Loads Flipper in React Native templates. Call this in the onCreate method with something like
     * initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
     *
     * @param context
     * @param reactInstanceManager
     *
     */
    companion object {
        private fun initializeFlipper(
            context: Context,
            reactInstanceManager: ReactInstanceManager
        ) {
            if (BuildConfig.DEBUG) {
                try {
                    /*
                     We use reflection here to pick up the class that initializes Flipper,
                    since Flipper library is not available in release mode
                    */
                    val aClass = Class.forName("com.awesomeproject.ReactNativeFlipper");
                    aClass.getMethod(
                        "initializeFlipper",
                        Context::class.java,
                        ReactInstanceManager::class.java
                    )
                        .invoke(null, context, reactInstanceManager);
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace();
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace();
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace();
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace();
                }
            }
        }
    }
}
