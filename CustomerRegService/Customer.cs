using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace WCF_Service
{
    [DataContract(Namespace = "uk.ac.bcu.cmp7038.wcf")]
    public class Customer
    {
        [DataMember]
        public int CustomerID;
        [DataMember]
        public string Name;
        [DataMember]
        public string EmailAddress;
        [DataMember]
        public string Phone;

        public int GetCustomerID()
        {
            return CustomerID;
        }

        public string GetName()
        {
            return Name;
        }

        public string GetEmailAddress()
        {
            return EmailAddress;
        }

        public string GetPhone()
        {
            return Phone;
        }

        public void SetCustomerID(int id)
        {
            CustomerID = id;
        }

        public void SetName(string name)
        {
            Name = name;
        }

        public void SetEmailAddress(string addrs)
        {
            EmailAddress = addrs;

        }

        public void SetPhone(string ph)
        {
            Phone = ph;
        }
    }
}