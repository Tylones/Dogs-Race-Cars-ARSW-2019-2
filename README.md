# Dogs-Race-Case-ARSW-2019-2


## Part I

### 1)


### 2)


### 3)

*see code*

## Part III

### 2)

[](https://i.imgur.com/PzFOVsJ.png)

In this screenshot of the result of the race, we can see that several dogs have the same position. This is due to the fact that the access to the 
value of the variable **ultimaPosicionAlcanzada** in the class **RegistroLlegada** isn't synchronized. As a result, it's possible for two 
dogs to get the same value if they try to read the value at the same time. To solve this problem, we have to make the class **RegistroLlegada** ThreadSafe or when it is used.


### 3)

*see code*

### 4)

*see code*
