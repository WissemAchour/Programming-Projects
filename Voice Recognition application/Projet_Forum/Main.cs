using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Speech.Recognition;
using System.Speech.Synthesis;
using System.Threading;
namespace WindowsFormsApplication1
{
    public partial class Main : Form
    {
        //private Main form1;
        private Eniso form2;
        private Meca form3;
        private Car form4;
        private Test form5;
        private teach form6;
        SpeechSynthesizer speech = new SpeechSynthesizer();
        public Main()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            
            form2=new Eniso();
            form2.Show();
       
            
        }

        private void button2_Click(object sender, EventArgs e)
        {
            form3 = new Meca();
            form3.Show();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            form4 = new Car();
            form4.Show();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            form5 = new Test();
            form5.Show();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            form6 = new teach();
            form6.Show();
        }



        

      
    }
}
