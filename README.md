# TutorialBox Compose
[![](https://jitpack.io/v/pdrozz/tutorialbox-compose.svg)](https://jitpack.io/#pdrozz/tutorialbox-compose)
[![API](https://img.shields.io/badge/API-23%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=23)

Highlight composable views of your App using Jetpack Compose. 

<div>
<img src="https://user-images.githubusercontent.com/59422918/215327931-f0aabb79-62cf-4603-a540-4d4be385392c.gif" height=400 />
<img src="https://user-images.githubusercontent.com/59422918/215329851-adf2d988-c14d-490a-a190-52b0f4a3b3d5.png" height=400 />
<img src="https://user-images.githubusercontent.com/59422918/215329876-20fc52a9-e5f9-4cad-93d4-43d9c2f4c8ee.png" height=400 />
<img src="https://user-images.githubusercontent.com/59422918/215329989-bd188f1f-09db-4bfa-b70d-e275d2ea1aba.png" height=400 />
</div>


## Dependency

### JitPack

``` Groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
  implementation 'com.github.pdrozz:tutorialbox-compose:1.1.0'
}
```

## Usage

### Step 1:

Wrap your compose content with TutorialBox

``` kotlin
val showTutorial = remember {
  mutableState = true
}

TutorialBox(
    state = rememberTutorialBoxState(),
    showTutorial = showTutorial,
    onTutorialCompleted = {
        showTutorial = false
    }
){
  Column(){
    Text("Text 1")
    
    Text("Text 2")
    
    Button(onClick = {}){
      Text("Click me")
    }
  }
}
```

### Step 2:

Inside the TutorialBoxScope adds the **Modifier.markForTutorial()** in the content

``` Kotlin
.markForTutorial(
    index = 0,
    title = "Profile icon",
    description = "This is profile icon description"
)
```

or there is two ways to customize with your compose layout.

#### TutorialBox -> Provide a custom layout in TutorialBox
``` Kotlin
TutorialBox(
    state = rememberTutorialBoxState(),
    showTutorial = showTutorial,
    onTutorialCompleted = {
        showTutorial = false
    },
    tutorialTarget = { index ->
      CustomCompose(index)
    }
){
```

#### Modifier -> Provide a custom layout in **Modifier.markForTutorial**
``` Kotlin
.markForTutorial(
    index = 0,
    content = {
        CustomTutorialCompose()
    }
)
```

### Finally:

Adjust the index according to the display order

``` kotlin
val showTutorial = remember {
  mutableState = true
}

TutorialBox(
    state = rememberTutorialBoxState(),
    showTutorial = showTutorial,
    onTutorialCompleted = {
        showTutorial = false
    }
){
  Column(){
    Text(
      modifier = Modifier
        .markForTutorial(
          index = 0,
          title = "Text 1 Title",
          description = "This is text 1 description"
        )
      text = "Text 1"
    )
    
    Text(
      modifier = Modifier
        .markForTutorial(
          index = 1,
          title = "Text 2 Title",
          description = "This is text 2 description"
        )
      text = "Text 2"
    )
    
    Button(onClick = {}){
      Text("Click me")
    }
  }
}
```

# Bugs and Feedback
For bugs, questions and discussions please use the [Github Issues](https://github.com/pdrozz/tutorialbox-compose/issues).
