from flask import Flask, request, jsonify
import joblib
import numpy as np

# Cargar el modelo entrenado
modelAnimales = joblib.load("Modelos zoo iris/modelo_naive_bayes.joblib")
modelFlores = joblib.load("Modelos zoo iris/modelo_naive_bayes_iris.joblib")

app = Flask(__name__)

@app.route('/predict/animals', methods=['POST'])
def predict_animals():
    data = request.json
    features = np.array([
        data['hair'], data['feathers'], data['eggs'], data['milk'], data['airbone'],
        data['aquatic'], data['predator'], data['toothed'], data['backbone'], data['breathes'],
        data['venomous'], data['fins'], data['legs'], data['tail'], data['domestic'], data['catsize']
    ]).reshape(1, -1)
    probabilities = modelAnimales.predict_proba(features)[0]
    class_names = modelAnimales.classes_
    prediction = {f"Class: {cls}": f"Probability: {prob * 100:.2f}%" for cls, prob in zip(class_names, probabilities)}
    return jsonify(prediction)

@app.route('/predict/iris', methods=['POST'])
def predict_iris():
    data = request.json
    features = np.array([data['a1'], data['a2'], data['a3'], data['a4']]).reshape(1, -1)
    probabilities = modelIris.predict_proba(features)[0]
    class_names = modelIris.classes_
    prediction = {f"Clase: {cls}": f"Probabilidad: {prob * 100:.2f}%" for cls, prob in zip(class_names, probabilities)}
    return jsonify(prediction)

if __name__ == '__main__':
    app.run(debug=True)
