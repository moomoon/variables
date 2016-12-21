# variables
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
