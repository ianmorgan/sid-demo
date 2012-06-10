## Routing

### Introduction

Routes are setup by simple pattern matching. A basic pattern looks like

	GET:/account/:id
	
This will match the following URLs:

``` http://example.com/account/27 ```
	
and
	
``` http://example.com/account?id=27 ```

	
This simple example demonstrates an important principle. The matching generally doesn't care about 
just how that data is passed in the URL provided it can meet the rules. In this case `id` can passed 
in the URL or as a traditional parameter. For `POST` requests it could also be passed in the submitted 
form data.  

More advanced patterns are described below

### Single Wildcards 

```*``` (_asterisk_) will match anything once 

	GET:/say/*/to/*

Will match:  

``` http://example.com/say/hello/to/world ```


### Globbing Wildcards 

```**``` (_two asterisks_) at the end of the pattern will match anything. This is sometimes called globbing

	GET:/demo/**

Will match:  

``` http://example.com/demo/examples/helloworld ```

``` http://example.com/demo/routing ```


 



