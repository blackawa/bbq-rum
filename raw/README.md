# jp.blackawa.bbq-rum/raw

First of all, you need simple and first rum component.

This project shows how to implement bidirectional binding with Rum.

## How can I try this?

Run:

```
lein repl
user=> (dev)
dev=> (start)
Figwheel: Starting server at http://0.0.0.0:3449
Figwheel: Watching build - dev
Compiling build :dev to "resources/public/js/main.js" from ["src"]...
Successfully compiled build :dev to "resources/public/js/main.js" in 0.73 seconds.
dev=> (cljs-repl)
Launching ClojureScript REPL for build: dev
Figwheel Controls:
          (stop-autobuild)                ;; stops Figwheel autobuilder
          (start-autobuild id ...)        ;; starts autobuilder focused on optional ids
          (switch-to-build id ...)        ;; switches autobuilder to different build
.......etc,etc,etc,
Prompt will show when Figwheel connects to your application
To quit, type: :cljs/quit
nil
```

Then open http://localhost:3449/index.html .

## I feel tough...

If you felt tough to understand this project, these links will help you.

- I do not understand lein! => https://leiningen.org/
- I do not understand `(dev)` and `(start)` => https://github.com/stuartsierra/component and https://github.com/stuartsierra/reloaded
- I do not understand figwheel => https://github.com/bhauman/lein-figwheel
- I do not understand React => https://reactjs.org/
