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
    public partial class Eniso : Form
    {
        SpeechSynthesizer speech = new SpeechSynthesizer();
       
        public Eniso()
        {
            InitializeComponent();
           
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            speech.Rate = -2;
            speech.Speak("The National Engineering School of Sousse (Eniso) was established in July 2005 in response to a national need for engineers in specialties innovative edge. mechatronics industrial electronics and informatics. These specialties allow the Eniso to distinguish themselves from other national schools of engineering. Each of the three courses offer transf,erable skills to help our engineers their employability. The various programs offered are aiming to equip students with basic knowledge engineers solid to continually adapt to changing technology. These programs also allow them to acquire in-depth skills of advanced technologies, to implement and develop them.");

        }
        
    }
}

/*
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
    public partial class Form1 : Form
    {
        SpeechSynthesizer speech = new SpeechSynthesizer();
        SpeechRecognitionEngine recog = new SpeechRecognitionEngine();

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            speech.Rate = -2;
           // speech.Speak("hello there i am IA 12. I hope you are interested in voice recognition ");
            
            Choices tab = new Choices();
            tab.Add(new String[] { "hello"," ", "kaftegy", "chappati","add" ,"plus","one","representation","recharge","up","down","left","Right","eniso"});
            GrammarBuilder gb = new GrammarBuilder(tab);
            gb.Append(tab);
            Grammar g = new Grammar(gb);
            recog.LoadGrammar(g);
            recog.SetInputToDefaultAudioDevice();
            recog.LoadGrammar(new DictationGrammar());
            recog.SpeechRecognized += new EventHandler<SpeechRecognizedEventArgs>(recog_SpeechRecognized);
            recog.RecognizeAsync(RecognizeMode.Multiple);
        }

        void recog_SpeechRecognized(object sender, SpeechRecognizedEventArgs e)
        {
            foreach (RecognizedWordUnit word in e.Result.Words)
                textBox1.Text = word.Text;
            int x = pictureBox1.Location.X;
            while (textBox1.Text.Equals("Right"))
            {
                pictureBox1.SetBounds(x = x + 5, pictureBox1.Location.Y, pictureBox1.Width, pictureBox1.Height);
                System.Threading.Thread.Sleep(50);
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            int x=pictureBox1.Location.X;
        if(textBox1.Text.Equals("Right"))
            pictureBox1.SetBounds(x=x+5,pictureBox1.Location.Y,pictureBox1.Width,pictureBox1.Height);
        }

        
    }
}
*/