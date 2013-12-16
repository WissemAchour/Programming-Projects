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
    public partial class teach : Form
    {
        SpeechSynthesizer speech = new SpeechSynthesizer();
        SpeechRecognitionEngine recog = new SpeechRecognitionEngine();
        Choices tab = new Choices();
        public teach()
        {
            InitializeComponent();
            tab.Add(new String[] { "hello", " ", "start", "add", "plus", "one", "nord", "tension", "representation", "recharge", "up", "down", "left", "Right", "eniso" });
            GrammarBuilder gb = new GrammarBuilder(tab);
            gb.Append(tab);
            Grammar g = new Grammar(gb);
            recog.LoadGrammar(g);
            recog.SetInputToDefaultAudioDevice();
            recog.LoadGrammar(new DictationGrammar());

            recog.SetInputToDefaultAudioDevice();
            recog.LoadGrammar(new DictationGrammar());
        }

        private void teach_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            String word;
            word = textBox1.Text;
            tab.Add(word);
            GrammarBuilder gb = new GrammarBuilder(tab);
            gb.Append(tab);
            Grammar g = new Grammar(gb);
            recog.LoadGrammar(g);
           
        }

        private void button2_Click(object sender, EventArgs e)
        {
            
            recog.SpeechRecognized += new EventHandler<SpeechRecognizedEventArgs>(recog_SpeechRecognized);
            recog.RecognizeAsync(RecognizeMode.Multiple);
            button2.Enabled = false;
        }
        void recog_SpeechRecognized(object sender, SpeechRecognizedEventArgs e)
        {

            foreach (RecognizedWordUnit word in e.Result.Words)
            {
                textBox2.Text = word.Text;
            }
        }
    }
}
