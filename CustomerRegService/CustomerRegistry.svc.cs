using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WCF_Service
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "CustomerRegistry" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select CustomerRegistry.svc or CustomerRegistry.svc.cs at the Solution Explorer and start debugging.
    public class CustomerRegistry : ICustomerRegistry
    {
        Dictionary<int, Customer> customers = new Dictionary<int, Customer>();

        public CustomerRegistry()
        {
            Customer cust1 = new Customer();
            cust1.SetCustomerID(101);
            cust1.SetEmailAddress("John@crs.org");
            cust1.SetName("John");
            cust1.SetPhone("0765");

            customers.Add(101, cust1);

            
            Customer cust2 = new Customer();
            cust2.SetCustomerID(102);
            cust2.SetEmailAddress("Rob@crs.org");
            cust2.SetName("Rob");
            cust2.SetPhone("0975");

            customers.Add(102, cust2);

        }

        public bool AddCustomer(Customer customer)
        {
            if (customers.ContainsKey(customer.CustomerID))
                return false;
            else
            {
                Console.WriteLine(customers.Count + " and Adding " + customer.CustomerID);
                customers.Add(customer.CustomerID, customer);
                Console.WriteLine(customers.Count + " after Adding " + customer.CustomerID);

                return true;
            }

        }

        public Customer GetCustomer(int customerID)
        {
            Console.WriteLine(customers.Count + " Searching " + customerID);
            Customer value = null;
            if (customers.ContainsKey(customerID))
            {
                value = customers[customerID];
            }
            //customers.TryGetValue(customerID, out value);
            Console.WriteLine(" and found " + value.Name);
            return value;
        }

        public bool DeleteCustomer(int customerID)
        {
            if (customers.ContainsKey(customerID))
            {
                customers.Remove(customerID);
                return true;
            }
            else return false;
        }

        public bool CheckCustomer(int customerID)
        {
            if (customers.ContainsKey(customerID))
                return true;
            else 
                return false;
        }
    }
    
}
