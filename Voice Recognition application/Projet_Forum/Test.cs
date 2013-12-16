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
    public partial class Test : Form
    {
        int i = 0;
        int j=0;
        int correct=0;
        SpeechSynthesizer speech = new SpeechSynthesizer();
        SpeechRecognitionEngine recog = new SpeechRecognitionEngine();
        Choices tab = new Choices();
        String[] affichage= new String[]{"comment","ouest","est","informatique","nord","tension","mécanique","recharge"};
        public Test()
        {
            InitializeComponent();
            tab.Add(new String[] { "hello", " ", "start", "kaftegy", "chappati", "add", "plus", "one", "nord","tension","representation", "recharge", "up", "down", "left", "Right", "eniso" });
            GrammarBuilder gb = new GrammarBuilder(tab);
            gb.Append(tab);
            Grammar g = new Grammar(gb);
            recog.LoadGrammar(g);
            recog.SetInputToDefaultAudioDevice();
            recog.LoadGrammar(new DictationGrammar());
        }

       

        private void button1_Click(object sender, EventArgs e)
        {
            System.Threading.Thread.Sleep(2000);
            button1.Visible = false;
            speech.Rate = -2;
            label1.Text = "Say anything";
            recog.SpeechRecognized += new EventHandler<SpeechRecognizedEventArgs>(recog_SpeechRecognized);
            recog.RecognizeAsync(RecognizeMode.Multiple);
        }

        void recog_SpeechRecognized(object sender, SpeechRecognizedEventArgs e)
        {
            
              if(i<8)  
            label1.Text = affichage[i];
            
            foreach (RecognizedWordUnit word in e.Result.Words)
            {
                j++;
                if (i == 8)
                {
                    i++;
                    speech.Speak("you tried"+(j/2-1)+"times and your score is "+(1000-(j/2-1)*10));
                    MessageBox.Show("The test is over and your score is "+(1000-(j/2-1)*10));
                    this.Close();
                    
                    break;

                }
               
                if (word.Text.Equals(affichage[i]) & i < 8)
                {
                    
                    correct++;
                    i++;
                    speech.Speak("Correct pronunciation ,And now say anything to continue! ");

                }
            }

        }
      
    }
}
