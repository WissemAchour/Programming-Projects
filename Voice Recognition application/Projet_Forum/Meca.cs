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
    public partial class Meca : Form
    {
        SpeechSynthesizer speech = new SpeechSynthesizer();
        public Meca()
        {
            InitializeComponent();
        }

        private void Meca_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
             speech.Rate = -2;
             speech.Speak("On 4 November 2011, few of students of Eniso have invested  to honor their establishment . It is the creation of a new club intends to build its own identity. today 80 members consisting of three branches: mechatronics, industrial electronics and informatics. This young crowd quickly gained a great reputation for the quality and diversity of its shares up your mind . The club was ranked second in the compe,tition tuni,robots last year,Produced a command card of CNC . CAD of a buggy and * Several workshops");










        }
    }
}
