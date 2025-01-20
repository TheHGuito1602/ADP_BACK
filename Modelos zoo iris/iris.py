import pandas as pd
import numpy as np
from sklearn.model_selection import StratifiedKFold
from sklearn.naive_bayes import GaussianNB
from sklearn.metrics import accuracy_score
from sklearn.preprocessing import LabelEncoder


def load_data(filename):
    try:
        df = pd.read_csv(filename)
        print(f"Datos cargados correctamente desde: {filename}")
        return df
    except Exception as e:
        print(f"Error al cargar el archivo {filename}: {e}")
        return None

def train_and_evaluate(filename):
    data = load_data(filename)
    if data is None:
        print("No se pudieron cargar los datos. Terminado.")
        return

    X = data.iloc[:, :-1].values  # Todas las columnas menos la última
    y = data.iloc[:, -1].values   # Última columna (la clase)

    # Codificar etiquetas
    label_encoder = LabelEncoder()
    y_encoded = label_encoder.fit_transform(y)
    class_names = label_encoder.classes_

    # Validación cruzada estratificada
    skf = StratifiedKFold(n_splits=5, shuffle=True, random_state=42)
    model = GaussianNB()
    accuracies = []

    for train_idx, val_idx in skf.split(X, y_encoded):
        X_train, X_val = X[train_idx], X[val_idx]
        y_train, y_val = y_encoded[train_idx], y_encoded[val_idx]
        
        model.fit(X_train, y_train)
        y_pred = model.predict(X_val)
        accuracies.append(accuracy_score(y_val, y_pred))

    print(f"\nPrecisión promedio: {np.mean(accuracies):.3f} (+/- {np.std(accuracies):.3f})")
    print("\nEl modelo ha sido entrenado con éxito.")

    # Guardar el modelo
    import joblib
    joblib.dump(model, 'modelo_naive_bayes_iris.joblib')
    print("Modelo guardado como 'modelo_naive_bayes_iris.joblib'")

    # Predicción interactiva
    print("\nProporcione los valores para las características una por una:")
    feature_names = ['A1', 'A2', 'A3', 'A4']  
    user_features = []
    for feature in feature_names:
        while True:
            try:
                value = float(input(f"{feature}: "))
                user_features.append(value)
                break
            except ValueError:
                print("Por favor, introduzca un número válido.")


    probabilities = model.predict_proba([user_features])[0]
    print("\nPredicción de probabilidades por clase:")
    for cls, prob in zip(class_names, probabilities):
        print(f"Clase: {cls}, Probabilidad: {prob * 100:.2f}%")


if __name__ == "__main__":
    filename = "iris.csv" 
    train_and_evaluate(filename)
