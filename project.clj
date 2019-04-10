(defproject cyberoctopi "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.520"]
                 [io.pedestal/pedestal.service "0.5.5"]
                 [io.pedestal/pedestal.service-tools "0.5.5"]
                 [io.pedestal/pedestal.immutant "0.5.5"]
                 [metosin/reitit "0.3.1"]
                 [metosin/reitit-pedestal "0.3.1"]
                 [ch.qos.logback/logback-classic "1.2.3" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.25"]
                 [org.slf4j/jcl-over-slf4j "1.7.25"]
                 [org.slf4j/log4j-over-slf4j "1.7.25"]
                 [com.stuartsierra/component "0.4.0"]
                 [reloaded.repl "0.2.4"]
                 [reagent "0.8.1"] 
                 [re-frame "0.10.6"]]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :source-paths ["src/clj" "src/cljs"]
  :resource-paths ["config", "resources"]
  ;:target-path "target/%s/"
  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :min-lein-version "2.5.3"



  :profiles {:uberjar {:aot :all
                       :omit-source true
                       :prep-tasks ["compile" ["cljsbuild" "once" "min"]]}
             
             :dev {:dependencies [[io.pedestal/pedestal.service-tools "0.5.5"]
                                  [figwheel-sidecar "0.5.18"]
                                  [cider/piggieback "0.4.0"]
                                   [binaryage/devtools "0.9.10"]]
                   :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}
                   :plugins      [[lein-figwheel "0.5.18"]]}}


  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "cyberoctopi.core/mount-root"}
     :compiler     {:main                 cyberoctopi.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true
                    :preloads             [devtools.preload]
                    :external-config      {:devtools/config {:features-to-install :all}}
                    }}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            cyberoctopi.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}


    ]}
;  :repl-options {:init-ns cyberoctopi.core}
 ; :main ^{:skip-aot true} cyberoctopi.server
  )
