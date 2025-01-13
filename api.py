from flask import Flask, request, jsonify
import joblib
import numpy as np

# Cargar el modelo entrenado
modelAnimales = joblib.load("modelA.pkl")
modelFlores = joblib.load("modelF.pkl")

app = Flask(__name__)

@app.route('/predict/animals', methods=['POST'])
def predict():
    data = request.json
    features = np.array(data['features']).reshape(1, -1)
    prediction = modelAnimales.predict(features)
    return jsonify({'prediction': int(prediction[0])})

@app.route('/predict/flowers', methods=['POST'])
def predict():
    data = request.json
    features = np.array(data['features']).reshape(1, -1)
    prediction = modelFlores.predict(features)
    return jsonify({'prediction': int(prediction[0])})

if __name__ == '__main__':
    app.run(debug=True)
