(ns migratus-test.db.core
  (:require
   [mount.core :refer [defstate]]
   [conman.core :as conman]))

(defstate ^:dynamic *db*
  :start (conman/connect! {:jdbc-url "jdbc:sqlite:test_dev.db"
                           :maximum-pool-size 10
                           :leak-detection-threshold 10000
                           :connection-timeout 30000})
  :stop (conman/disconnect! *db*))

(conman/bind-connection *db* "sql/queries.sql")