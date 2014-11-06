(defproject digits "1.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [net.mikera/core.matrix "0.31.1"]
                 [com.intellij/forms_rt	"7.0.3"]]
  :profiles {:dev {:dependencies [[speclj "3.1.0"]]}}
  :plugins [[speclj "3.1.0"]]
  :test-paths ["spec"]
  :java-source-paths ["src"]

  :main digits.core)
