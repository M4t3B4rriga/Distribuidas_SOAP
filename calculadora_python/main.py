from zeep import Client
from zeep.exceptions import Fault

# URL del WSDL del servicio SOAP
wsdl = "http://www.dneonline.com/calculator.asmx?WSDL"

# Crear el cliente SOAP
client = Client(wsdl=wsdl)

# Inspeccionar servicios y puertos
print("Servicios disponibles:")
for service_name, service in client.wsdl.services.items():
    print(f"- Servicio: {service_name}")
    for port_name, port in service.ports.items():
        print(f"  Puerto: {port_name}")
        print("  Métodos disponibles:")
        for operation in port.binding._operations.values():
            print(f"    - {operation.name}")
# Funciones para realizar operaciones aritméticas
try:
    # Suma
    suma_resultado = client.service.Add(intA=10, intB=20)
    print(f"\nResultado de la suma: {suma_resultado}")

    # Resta
    resta_resultado = client.service.Subtract(intA=10, intB=20)
    print(f"Resultado de la resta: {resta_resultado}")

    # Multiplicación
    multiplicacion_resultado = client.service.Multiply(intA=10, intB=20)
    print(f"Resultado de la multiplicación: {multiplicacion_resultado}")

    # División
    division_resultado = client.service.Divide(intA=20, intB=10)
    print(f"Resultado de la división: {division_resultado}")

except Fault as fault:
    print(f"Error: {fault}")
