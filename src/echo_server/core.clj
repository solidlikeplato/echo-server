(ns echo_server.core
  (:gen-class))

(require '[clojure.string :as str])

(defn write-hello-world []
  (println "hello world!"))

(defn -main []
  (write-hello-world ))
