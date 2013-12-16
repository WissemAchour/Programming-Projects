using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Net.Mail;
using System.Net;
namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
           
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MailMessage mail = new MailMessage();
            mail.From = new MailAddress(textBox3.Text);
            mail.Subject = textBox1.Text;
            mail.Body = textBox2.Text;
            foreach (String s in textBox5.Text.Split(';'))
                mail.To.Add(textBox5.Text);
            SmtpClient client = new SmtpClient();
            client.Credentials = new NetworkCredential(textBox3.Text,textBox4.Text);
            client.Host = "smtp.gmail.com";
            client.Port = 587;
            client.EnableSsl = true;
            client.Send(mail);
        }




       
    }
}
