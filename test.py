import joblib
import numpy as np

modelAnimales = joblib.load("Modelos zoo iris/modelo_naive_bayes.joblib")
test_input = np.array([[1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 4, 1, 0, 1]])
probabilities = modelAnimales.predict_proba(test_input)[0]
class_names = modelAnimales.classes_

for cls, prob in zip(class_names, probabilities):
    print(f"Class: {cls}, Probability: {prob * 100:.2f}%")
