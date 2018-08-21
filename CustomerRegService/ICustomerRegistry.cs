using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WCF_Service
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "ICustomerRegistry" in both code and config file together.
    [ServiceContract(Namespace = "uk.ac.bcu.cmp7038.wcf")]
    public interface ICustomerRegistry
    {
        [OperationContract]
        bool AddCustomer(Customer customer);
        [OperationContract]
        Customer GetCustomer(int customerID);
        [OperationContract]
        bool DeleteCustomer(int customerID);
        [OperationContract]
        bool CheckCustomer(int customerID);
    }
}
