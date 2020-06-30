<h1 align="center">Welcome to starling-insights-api 👋</h1>
<p>
</p>

> An API built with micronaut that interacts with my banking data, served with the Starling API. [This python script](https://github.com/Leolebleis/starling-insights-script) runs once a month and fetches all the data from this API, deployed on heroku using docker. This project was fun and is a good building block to build more API integration with Starling :).

## Run it

`./gradlew run` to run the app.

You will need a Starling personal token to go inside your `Authorization` header for your requests.

[Deploy Micronaut apps on Heroku using:](https://maccoda.github.io/deploying-micronaut-heroku/)
```
./gradlew stage
heroku container:push web
heroku container:release web
```

Doing `./gradlew stage` meant adding this to `build.gradle`:
```
task stage {
    dependsOn "build"
    dependsOn "clean"
    build.mustRunAfter "clean"
}
```

## Author

👤 **Leo Le Bleis**

* Website: https://www.leolebleis.com/
* Github: [@leolebleis](https://github.com/leolebleis)
* LinkedIn: [@leolebleis](https://linkedin.com/in/leolebleis)

## Show your support

Give a ⭐️ if this project helped you!

***
_This README was generated with ❤️ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
