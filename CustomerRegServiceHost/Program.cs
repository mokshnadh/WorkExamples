using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ServiceModel;
using System.ServiceModel.Description;
using WCF_Service;

namespace WCF_Service_Host
{
    class Program
    {
        static void Main(string[] args)
        {
            // Step 1 Create a URI to serve as the base address.
            Uri baseAddress = new Uri("http://cmp7038-PC:8888/WCF_Service/");

            // Step 2 Create a ServiceHost instance
            ServiceHost selfHost = new ServiceHost(typeof(CustomerRegistry), baseAddress);

            try
            {
                // Step 3 Add a service endpoint.
                selfHost.AddServiceEndpoint(typeof(ICustomerRegistry), new BasicHttpBinding(), "CustomerRegistry");

                
                // Step 4 Enable metadata exchange.
                ServiceMetadataBehavior smb = new ServiceMetadataBehavior();
                smb.HttpGetEnabled = true;
                
                selfHost.Description.Behaviors.Add(smb);

                // Step 5 define service behavior as single, so that the service maintain state.
                ServiceBehaviorAttribute sba = selfHost.Description.Behaviors.Find<ServiceBehaviorAttribute>();
                sba.InstanceContextMode = InstanceContextMode.Single;
                sba.ConcurrencyMode = ConcurrencyMode.Single;
                
                // Step 6 Start the service.
                selfHost.Open();

                Console.WriteLine("The service is ready.");
                Console.WriteLine("Press <ENTER> to terminate service.");
                Console.WriteLine();
                Console.ReadLine();

                // Close the ServiceHostBase to shutdown the service.
                selfHost.Close();
            }
            catch (CommunicationException ce)
            {
                Console.WriteLine("An exception occurred: {0}", ce.Message);
                selfHost.Abort();
            }
        }
    }
}
