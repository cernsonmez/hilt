# Dagger Hilt
Hilt is one of the most popular dependency injection libraries that developted by Jetpack. 
Creating your Dagger setup code is one step ahead of Dagger.
Hilt is aimed to increase the testability, readability and reusability of the code.

## How to implement to your project:

1) build.gradle/app
```
dependencies {
     classpath 'com.google.dagger:hilt-android-gradle-plugin:2.40.5'
}
```
2) build.gradle/project
plugin

```
    id 'kotlin-kapt'
    id 'dagger.hilt.android.plugin'
```
dependencies
```
    implementation "com.google.dagger:hilt-android:2.38.1"
    kapt "com.google.dagger:hilt-compiler:2.38.1"
```

3) First of all Hilt need to know where our application class. Because of that we should create an application class and annotate with @HiltAndroidApp. 
For example:
```
@HiltAndroidApp
class App : Application()
```

> Do not forget to add our new Application class to AndroidManifest file :)

4) I prefer to create an app module as the next step. 
Here, I define all the providers required for Hilt in order to be able to inject them later in the relevant places.
You can cheat with following [table*](https://dagger.dev/hilt/components#component-lifetimes)

|Component	|Scope	|Created at	|Destroyed at|
------------- | ------------- | ------------- | ------------- 
|SingletonComponent	|@Singleton	|Application#onCreate()	|Application#onDestroy()|
|ActivityRetainedComponent|	@ActivityRetainedScoped|	Activity#onCreate()1|	Activity#onDestroy()1|
|ViewModelComponent	|@ViewModelScoped	|ViewModel created	|ViewModel destroyed|
|ActivityComponent	|@ActivityScoped	|Activity#onCreate()	|Activity#onDestroy()|
FragmentComponent	|@FragmentScoped	|Fragment#onAttach()	|Fragment#onDestroy()|
ViewComponent|	@ViewScoped	|View#super()|	View destroyed|
ViewWithFragmentComponent|	@ViewScoped|	View#super()|	View destroyed|
ServiceComponent	|@ServiceScoped|	Service#onCreate()|	Service#onDestroy()|

