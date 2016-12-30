# variables  [![](https://jitpack.io/v/moomoon/variables.svg)](https://jitpack.io/#moomoon/variables)
Delegated property for java.



```java
      Val<Integer> lazyVal = new Variables.Lazy<Integer>() {
          @Override public Integer create() {
              return some calculation;
          }
      }; 
        
      Var<Integer> observableVal = new Variables.Observable<Integer>(0) {

          @Override public void onChange(Integer oldValue, Integer newValue) {
              do your thing;
          }
      };

```



## Installation
Available via [JitPack](https://jitpack.io/).

###Step 1.
Add it in your root build.gradle at the end of repositories:
```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
###Step 2. 
Add the dependency
```groovy
	dependencies {
	        compile 'com.github.moomoon:variables:1.0.1'
	}
```

