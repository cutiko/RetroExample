## Getting Started

1. git clone
2. Create this file inside `network` package

```
public class Mashape {

    public static final String KEY = "HERE GOES YOUR KEY";

}
```

### Retrofit Example

1. Install Retrofit and GSON converter
2. Create your model
3. Create an interface with a request method inside
4. Check this [gist](https://gist.github.com/cutiko/e8b75896ae12aff9fc580f33fb310e7e) and choose an interceptor as a template
5. Create the interceptor class and method based on your previous selection
6. Create an asynctask
7. Inside doInBackGround do the request http
8. **Don't forget the internet permission in the manifest**
9. Create an inner class extending your asynctask
10. Override in the inner asynctask the method with UI access
11. Always call your asynctaks using new and dot execute `new GetSomething().execute();`