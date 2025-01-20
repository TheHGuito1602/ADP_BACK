from flask import Flask, request, jsonify
from flask_cors import CORS
import joblib
import numpy as np

# Cargar los modelos entrenados
modelAnimales = joblib.load("Modelos zoo iris/modelo_naive_bayes.joblib")
modelIris = joblib.load("Modelos zoo iris/modelo_naive_bayes_iris.joblib")

app = Flask(__name__)
CORS(app)  # Habilitar CORS para desarrollo

@app.route('/predict/animals', methods=['POST'])
def predict_animals():
    try:
        data = request.json
        required_keys = [
            'hair', 'feathers', 'eggs', 'milk', 'airborne',
            'aquatic', 'predator', 'toothed', 'backbone', 'breathes',
            'venomous', 'fins', 'legs', 'tail', 'domestic', 'catsize'
        ]
        
        # Validar claves requeridas
        for key in required_keys:
            if key not in data:
                return jsonify({'error': f'Missing key: {key}'}), 400
        
        # Extraer características y predecir
        features = np.array([
            data['hair'], data['feathers'], data['eggs'], data['milk'], data['airborne'],
            data['aquatic'], data['predator'], data['toothed'], data['backbone'], data['breathes'],
            data['venomous'], data['fins'], data['legs'], data['tail'], data['domestic'], data['catsize']
        ]).reshape(1, -1)
        
        probabilities = modelAnimales.predict_proba(features)[0]
        class_names = modelAnimales.classes_
        prediction = {f"Class: {cls}": f"Probability: {prob * 100:.2f}%" for cls, prob in zip(class_names, probabilities)}
        
        # Formatear la salida como se requiere
        formatted_prediction = "\n".join([f"Class: {cls}, Probability: {prob * 100:.2f}%" for cls, prob in zip(class_names, probabilities)])
        
        # Imprimir la predicción formateada para depuración
        print("Formatted prediction:", formatted_prediction)
        
        return jsonify({'model': 'zoo', 'predictions': formatted_prediction})
    except Exception as e:
        return jsonify({'error': str(e)}), 500

@app.route('/predict/iris', methods=['POST'])
def predict_iris():
    try:
        data = request.json
        print("Received data:", data)  # Debugging line
        required_keys = ['a1', 'a2', 'a3', 'a4']

        # Validar claves requeridas
        for key in required_keys:
            if key not in data:
                return jsonify({'error': f'Missing key: {key}'}), 400

        # Extraer características y predecir
        features = np.array([data['a1'], data['a2'], data['a3'], data['a4']]).reshape(1, -1)
        probabilities = modelIris.predict_proba(features)[0]
        class_names = modelIris.classes_
        
        # Formatear la salida como se requiere
        formatted_prediction = "Predicción de probabilidades por clase:\n" + "\n".join([f"Clase: {cls}, Probabilidad: {prob * 100:.2f}%" for cls, prob in zip(class_names, probabilities)])
        
        # Imprimir la predicción formateada para depuración
        print("Formatted prediction:", formatted_prediction)
        
        return jsonify({'model': 'iris', 'predictions': formatted_prediction})
    except Exception as e:
        return jsonify({'error': str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True)
