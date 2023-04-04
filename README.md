# Online-Bazaar-E-Commerce-app

-I have developed  a fully functional e-commerce app named OnlineBazaar. 

# APP DEMO

# Authentication 
![onlinebazaar1](https://user-images.githubusercontent.com/64928807/229808398-b628bbec-7c5f-455b-9645-eab184c8f846.gif)




# Architecture


This app implements MVVM architecture. App consist of different fragments and 1 root activity. Activity holds a container layout in order to manage fragments which will be controlled by navigation component. Here is the package structure:

![image](https://user-images.githubusercontent.com/64928807/219080594-d41f9c5c-6621-44dd-be6a-7fb2424b9150.png)

Data

Data package should include response models, data source. It shouldn't know any logic.

UI

UI like a feature. It contains Fragments,  and feature related classes like a domains, mappers and ui models. Make sure that all classes here are specific to the this feature. If it is a class that is also used in other features, it should be moved to the common package.

Di

This package may actually be inside the common module. But I prefer to carry outside of core package to be more visible.

Viewmodel

This package includes viewmodels.

Util

This package include utility class that has glide image loading etc.

**Tools that I used** :

- Firebase Authentication
- Navigation Component
- Hilt for dependency injection
- Retrofit 
- Room
- Coroutines
- Livedata
- View Binding
- Glide for image loading
- RESTApi
- LottieAnimationView
