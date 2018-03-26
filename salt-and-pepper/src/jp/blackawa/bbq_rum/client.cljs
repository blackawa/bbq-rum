(ns jp.blackawa.bbq-rum.client
  (:require [rum.core :as rum]
            [jp.blackawa.bbq-rum.flow :as flow]))

(enable-console-print!)

(println "Hello from cljs! :)")

(rum/defc +counter < rum/reactive [state]
  [:.card
   [:.card-content
    [:.navbar.is-light
     [:.navbar-brand
      [:a.navbar-item {:href "#"} "RumShop"]]
     [:.navbar-end
      [:a.navbar-item {:href "#"}
       [:span.icon [:i.fas.fa-shopping-cart]]
       [:span "Cart(" (:count (rum/react state)) ")"]]]]
    [:h2.title.is-4 "Lamb Chop 1kg"]
    ;; Dispatch will fire update action!
    [:button.button.is-success {:on-click #(flow/dispatch :increment-count)} "Add to cart"]]])

(rum/defc +app [state]
  [:.content
   [:h1.title "Welcome to Rum world!"]
   ;; Rum can render other components like function call.
   [:columns (+counter state)]])

(when-let [app (js/document.getElementById "app")]
  (rum/mount (+app flow/state) app))
