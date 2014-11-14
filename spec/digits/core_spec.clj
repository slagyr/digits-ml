(ns digits.core-spec
  (:require [speclj.core :refer :all]
            [digits.data :as data]
            [digits.classify :as classify]
            [digits.core :refer :all]))

(describe "Main"

   ;(it "cross validattion"
   ; (let [strategy (create-classifier (data/training-data))
   ;       validation (classify/cross-validate strategy 3)]
   ;   (println validation)
   ;   (should (> (:percentage-correct validation) 50))))

    )

;{:average-cost 0.0, :incorrect 22567.0, :roc-area {:0 0.907925104078354, :4 0.8095956240528533, :7 0.853113696677853, :1 0.9632719768452945, :8 0.9176677980270813, :9 0.7076857760876183, :2 0.8047582001395548, :5 0.8130658352873747, :3 0.7964500344082932, :6 0.6737285533532784}, :false-positive-rate {:0 0.06887081440794338, :4 0.049066652604935666, :7 0.22644219261150564, :1 0.032398970950798585, :8 0.03205314073332103, :9 0.039722839310271874, :2 0.1082410173703831, :5 0.013034943070278759, :3 0.012563414698929586, :6 0.015635316800042258}, :unclassified 0.0, :sf-entropy-gain 44501.05059822269, :kb-mean-information 1.2895191508935941, :kb-information 54159.80433753095, :percentage-incorrect 53.73095238095238, :root-relative-squared-error 86.5082291052704, :precision {:0 0.5142484634010058, :4 0.46306982111944606, :7 0.3070725156669651, :1 0.7604992076069731, :8 0.6963036963036963, :9 0.2874762808349146, :2 0.3149263721552878, :5 0.6419841840402588, :3 0.6654879773691655, :6 0.368196371398079}, :error-rate 0.5373095238095238, :percentage-unclassified 0.0, :recall {:0 0.6681994191674734, :4 0.3941552062868369, :7 0.8573051579186548, :1 0.819598633646456, :8 0.6861924686192469, :9 0.14469914040114612, :2 0.4505626047402442, :5 0.23530961791831356, :3 0.21627212135141347, :6 0.08339376359680928}, :correlation-coefficient {:nan Can't compute correlation coefficient: class is nominal!}, :mean-absolute-error 0.13448765305425822, :summary
;Correctly Classified Instances       19433               46.269  %
;Incorrectly Classified Instances     22567               53.731  %
;Kappa statistic                          0.4019
;Mean absolute error                      0.1345
;Root mean squared error                  0.2595
;Relative absolute error                 74.7392 %
;Root relative squared error             86.5082 %
;Coverage of cases (0.95 level)          96.5048 %
;Mean rel. region size (0.95 level)      62.9017 %
;Total Number of Instances            42000
;, :kb-relative-information 1631379.4677123788, :false-negative-rate {:0 0.3318005808325266, :4 0.605844793713163, :7 0.14269484208134514, :1 0.18040136635354398, :8 0.3138075313807531, :9 0.8553008595988538, :2 0.5494373952597558, :5 0.7646903820816864, :3 0.7837278786485865, :6 0.9166062364031907}, :relative-absolute-error 74.73917028364276, :root-mean-squared-error 0.25948333539748447, :sf-mean-entropy-gain 1.0595488237672068, :evaluation-object #<Evaluation weka.classifiers.Evaluation@705a06bf>, :confusion-matrix === Confusion Matrix ===
;
;    a    b    c    d    e    f    g    h    i    j   <-- classified as
; 2761   10  186    2  524   27   43  129  116  334 |    a = 0
;    3 3839    2    3   24    3    0  777    3   30 |    b = 1
;  225   32 1882  163   68   97   30 1334  301   45 |    c = 2
;  171  159 1159  941  110  279    4 1285  203   40 |    d = 3
;  536   94  191   99 1605    8  221  742  213  363 |    e = 4
;  155   87 1055   74   69  893    7 1333   90   32 |    f = 5
;  352  425  527   21  380   13  345 1493  124  457 |    g = 6
;  101  184  115   15  121   34   12 3773    8   38 |    h = 7
;  258   11  340   80  185   28   87  123 2788  163 |    i = 8
;  807  207  519   16  380    9  188 1298  158  606 |    j = 9
;, :kappa 0.4018651780797226, :f-measure {:0 0.5812019787390801, :4 0.4258423985141948, :7 0.4521812080536912, :1 0.788943690916564, :8 0.6912111069790504, :9 0.1925031766200762, :2 0.3707278636856101, :5 0.34438873891245664, :3 0.3264527320034692, :6 0.13598738667717775}, :percentage-correct 46.26904761904762, :correct 19433.0}
