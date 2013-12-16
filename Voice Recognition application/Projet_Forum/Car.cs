using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
using System.Speech.Recognition;
using System.Speech.Synthesis;
using System.Threading;
using System.Media;


namespace WindowsFormsApplication1
{
    
   
    public partial class Car : Form
    {
        SpeechSynthesizer speech = new SpeechSynthesizer();
        SpeechRecognitionEngine recog = new SpeechRecognitionEngine();
         Choices tab = new Choices();
            
            
        public Car()
        {
            InitializeComponent();
            tab.Add(new String[] {"recharge","eniso","nord","sud","ouest","est" });
            GrammarBuilder gb = new GrammarBuilder(tab);
            gb.Append(tab);
            Grammar g = new Grammar(gb);
            recog.LoadGrammar(g);
            recog.SetInputToDefaultAudioDevice();
            recog.LoadGrammar(new DictationGrammar());
            
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
            
        }

       

        private void button5_Click(object sender, EventArgs e)
        {
            speech.Rate = -2;

            
       
            recog.SpeechRecognized += new EventHandler<SpeechRecognizedEventArgs>(recog_SpeechRecognized);
            recog.RecognizeAsync(RecognizeMode.Multiple);
        }

        void recog_SpeechRecognized(object sender, SpeechRecognizedEventArgs e)
        {

            foreach (RecognizedWordUnit word in e.Result.Words)
            {
                    textBox1.Text = word.Text;
                    String s = word.Text;
                    int x = pictureBox1.Location.X;
                    int y = pictureBox1.Location.Y;

                    if (s.Equals("recharge"))
                    {
                        while (progressbar.Value < 100)
                        {
                            progressbar.Value += 5;
                            System.Threading.Thread.Sleep(200);
                        }
                    }

                    if (s.Equals("est") && progressbar.Value != 0)
                   {
                            FileStream fs = new FileStream(@"C:\Users\Wissem\Desktop\formations+club\voice\car3.png", FileMode.Open);
                            pictureBox1.Image = Image.FromStream(fs);
                            fs.Close();
                      
                            pictureBox1.SetBounds(x = x + 30, pictureBox1.Location.Y, pictureBox1.Width, pictureBox1.Height);
                            progressbar.Value -= 5;
                        

                    }


                   if (s.Equals("ouest")&&progressbar.Value!=0)
                   {
                       FileStream fs = new FileStream(@"C:\Users\Wissem\Desktop\formations+club\voice\car11.png", FileMode.Open);
                       pictureBox1.Image = Image.FromStream(fs);
                       fs.Close();

                       pictureBox1.SetBounds(x = x - 30, pictureBox1.Location.Y, pictureBox1.Width, pictureBox1.Height);
                       progressbar.Value -= 5;


                   }


                   if (s.Equals("nord") && progressbar.Value != 0)
                   {
                       FileStream fs = new FileStream(@"C:\Users\Wissem\Desktop\formations+club\voice\car4.png", FileMode.Open);
                       pictureBox1.Image = Image.FromStream(fs);
                       fs.Close();

                       pictureBox1.SetBounds(pictureBox1.Location.X, y=y-30, pictureBox1.Width, pictureBox1.Height);
                       progressbar.Value -= 5;


                   }


                   if (s.Equals("sud") && progressbar.Value != 0)
                   {
                       FileStream fs = new FileStream(@"C:\Users\Wissem\Desktop\formations+club\voice\car2.png", FileMode.Open);
                       pictureBox1.Image = Image.FromStream(fs);
                       fs.Close();

                       pictureBox1.SetBounds(pictureBox1.Location.X, y=y+30, pictureBox1.Width, pictureBox1.Height);
                       progressbar.Value -= 5;


                   }
                         



                    }
                

            }

       

        }
     /*   private void button1_Click(object sender, EventArgs e)
        {
            FileStream fs = new FileStream(@"C:\Users\Wissem\Desktop\formations+club\voice\car2.png", FileMode.Open);
            pictureBox1.Image = Image.FromStream(fs);
            fs.Close();
        }*/
       
        
    }

