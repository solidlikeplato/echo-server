(ns echo_server.core-test
  (:require [clojure.test :refer :all]
            [echo_server.core :refer :all])
  (:import (java.io ByteArrayOutputStream BufferedWriter OutputStreamWriter)))

(deftest writer-test
  (testing "writer writes to single string to stream correctly"
    (let [output (new ByteArrayOutputStream)
          out (new BufferedWriter (new OutputStreamWriter output))
          message "hello world"]

      (with-open [writer out]
        (socket-write writer message))

      (is (= message (.toString output)))))
    
    (testing "writer writes sequential strings stream correctly"
    (let [output (new ByteArrayOutputStream)
          out (new BufferedWriter (new OutputStreamWriter output))
          message "hello world "
          message2 "I'm an angry pink unicorn"]

      (with-open [writer out]
        (socket-write writer message)
        (socket-write writer message2))

      (is (= (str message message2) (.toString output))))))