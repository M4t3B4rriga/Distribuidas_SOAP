using System;
using System.Threading.Tasks;
using SOAPCalculatorClient; // Cambia esto si tu namespace es diferente

namespace SOAPCalculatorClient
{
    internal class Program
    {
        static async Task Main(string[] args)
        {
            // Crear cliente del servicio
            var client = new CalculatorSoapClient(CalculatorSoapClient.EndpointConfiguration.CalculatorSoap);

            try
            {
                // Ejemplo de operaciones
                Console.WriteLine("== Calculadora SOAP ==");

                int a = 15;
                int b = 5;

                Console.WriteLine($"Sumando {a} + {b}...");
                var suma = await client.AddAsync(a, b);
                Console.WriteLine($"Resultado de la suma: {suma}");

                Console.WriteLine($"Restando {a} - {b}...");
                var resta = await client.SubtractAsync(a, b);
                Console.WriteLine($"Resultado de la resta: {resta}");

                Console.WriteLine($"Multiplicando {a} * {b}...");
                var multiplicacion = await client.MultiplyAsync(a, b);
                Console.WriteLine($"Resultado de la multiplicación: {multiplicacion}");

                Console.WriteLine($"Dividiendo {a} / {b}...");
                var division = await client.DivideAsync(a, b);
                Console.WriteLine($"Resultado de la división: {division}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Ocurrió un error: {ex.Message}");
            }
            finally
            {
                // Cerrar el cliente
                if (client.State == System.ServiceModel.CommunicationState.Opened)
                {
                    client.Close(); // Cambiado a Close()
                }
            }

            Console.WriteLine("Presiona cualquier tecla para salir...");
            Console.ReadKey();
        }
    }
}
