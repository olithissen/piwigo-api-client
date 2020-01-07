# A Piwigo API client for Java

## Why?

The [Piwigo photo management server](https://piwigo.org/) comes with an RPC-like API. 
I want a quick way to triage and rate my photos which is kind of cumbersome with the otherwise nice web UI.
Since the only Java implementation is an integral part of the rudimentary Piwigo Android App I decieded to build my own.

## How?

```java
// Get a RestService instance
RestService service = new RestServiceFactory().createForUrl("http://example.com:8080/");

// Login
Response<LoginResponse> login = service.login("foo", "super$ekr1t").execute();

// Get top level categories
CategoriesResponse categories = service.getCategories().execute().body();

// Get a specific category by id
CategoriesResponse specificCategory = service.getCategories(5).execute().body();

// Get images from a specific category starting from page 0 and 10 items per page
ImagesResponse imagesInCategory = service.getImages(5, 0, 10).execute().body();

// Get detailed information on a specific image
ImageInfoResponse imageDetailsInfo = service.getImageInfo(1317).execute().body();
```

## Next?

* A lot more API calls (preferrably all of them)
* A refined model of the API results
* A better way to handle the optional API parameters
* A high-level API