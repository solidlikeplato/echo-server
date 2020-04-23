(ns echo_server.server-test
  (:require [clojure.test :refer :all]
            [echo_server.server :refer :all])
  (:import (java.io InputStreamReader BufferedReader BufferedWriter OutputStreamWriter)
           (java.net ServerSocket Socket)))

(require '[clojure.core.async :as async])

(deftest server-test
  (testing "server opens a socket on localhost and listens using given port"
    (let [port 5000]
      (async/go (server port)) 
      (let [socket (Socket. "127.0.0.1" port)]
      
      (is (= true (.isBound socket)))))))
