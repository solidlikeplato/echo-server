(ns echo_server.server
  (:require [echo_server.headers :refer :all]
            [clojure.string :as str])
  (:import (java.io InputStreamReader BufferedReader BufferedWriter OutputStreamWriter)
           (java.net ServerSocket))
  (:gen-class))

(defn server [port]
  (let [sock (ServerSocket. port)]
    (let [client-socket (. sock accept)]
      (.close client-socket))))
