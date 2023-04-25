# Online-Bazaar-E-Commerce-app

-I have developed  a fully functional e-commerce app named OnlineBazaar. 

# SCREENSHOTS
![1-splash screen](https://user-images.githubusercontent.com/64928807/234282439-d4f4b811-48ef-4357-b8bb-ce2652e2b28e.PNG)
![2-login screen](https://user-images.githubusercontent.com/64928807/234282519-52fde6ac-12b6-4a75-9d69-70bd6da99d9d.PNG)
![3-sign up screen](https://user-images.githubusercontent.com/64928807/234282580-5b7bf514-8308-46ec-9cdd-360bfdcb0052.PNG)
![4-product list](https://user-images.githubusercontent.com/64928807/234282604-35b61551-1e10-415f-8247-975fe60e0f0b.PNG)
![5-favorites screen](https://user-images.githubusercontent.com/64928807/234282685-63ceebf7-8bc1-42c5-9074-eb71deb2b426.PNG)
![6-user settings screen](https://user-images.githubusercontent.com/64928807/234282794-ddca92b1-ad08-4d7e-ace7-61e22d7c7710.PNG)



# APP DEMO

![onlinebazaar1](https://user-images.githubusercontent.com/64928807/229808398-b628bbec-7c5f-455b-9645-eab184c8f846.gif)
![onlinebazaar2](https://user-images.githubusercontent.com/64928807/229808548-18944e98-1f75-41e5-bec8-fe44d6cda8e5.gif)







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
