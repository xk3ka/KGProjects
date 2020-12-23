using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Implementation05
{
    public class Solution
    {
        public Element[] Elements { get; set; }

        public Data DataForm { get; set; }

        public Solution(Data dataform)
        {
            DataForm = dataform;
        }

        public void Generate(int length)
        {
            Elements = new Element[length];
            Random rnd = new Random();
            for(int i = 0; i <= Elements.Length-1; i++)
            {
                Elements[i] = new Element(20 + i * 40, 60, rnd.Next(0, 100), Color.Black);
            }
        }

        public void Sort()
        {
            for (var i = 0; i < Elements.Length / 2; i++)
            {
                bool swapFlag = false;

                for (var j = i; j < Elements.Length - i - 1; j++)
                {
                    if (Elements[j].Value > Elements[j + 1].Value)
                    {
                        Change(j, j + 1, i, j);
                        Swap(j, j + 1);
                        swapFlag = true;
                    }
                }

                for (var j = Elements.Length - 2 - i; j > i; j--)
                {
                    if (Elements[j - 1].Value > Elements[j].Value)
                    {
                        Change(j, j - 1, i, j);
                        Swap(j - 1, j);
                        swapFlag = true;
                    }
                }

                if (!swapFlag)
                {
                    break;
                }
            }
        }

        private void Swap(int i, int j)
        {
            Element tmp = Elements[i];
            Elements[i] = Elements[j];
            Elements[j] = tmp;
        }

        private void Change(int n1, int n2, int n, int m)
        {
            Elements[n1].Color = Color.Red;
            Elements[n2].Color = Color.Red;
            int x1 = Elements[n1].X;
            int x2 = Elements[n2].X;
            int y1 = Elements[n1].Y;
            double y;
            for (int t = 1; t <= 15; t++)
            {
                y = (x2 - x1) * t / 15;
                Elements[n1].X = x1 + (int)(y);
                switch (t)
                {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        y = 40 * t / 4;
                        Elements[n2].Y = y1 - (int)(y);
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        y = (x1 - x2) * (t - 4) / 7;
                        Elements[n2].X = x2 + (int)(y);
                        break;
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        y = 40 * (t - 11) / 4;
                        Elements[n2].Y = (int)(y1 - 40 + y);
                        break;
                }
                Thread.Sleep(15);
                Paint(n, m);
            }
            Elements[n1].Color = Color.Black;
            Elements[n2].Color = Color.Black;
            Paint(n, m);
        }

        public void Paint(int n, int m)
        {
            const int d = 15;
            string s;
            SizeF size;
            DataForm.GBitmap.Clear(Color.Pink);
            Pen pen = new Pen(Color.Black);
            Font font = new Font("Times New Roman", 12);
            for (int i = 0; i < Elements.Length; i++)
            {
                pen.Color = Elements[i].Color;
                DataForm.GBitmap.DrawEllipse(pen, Elements[i].X - d,
                Elements[i].Y - d, 2 * d, 2 * d);
                s = Convert.ToString(Elements[i].Value);
                size = DataForm.GBitmap.MeasureString(s, font);
                DataForm.GBitmap.DrawString(s, font, Brushes.Black,
                Elements[i].X - size.Width / 2,
                Elements[i].Y - size.Height / 2);
            }
            if (n != -1)
            {
                pen.Color = Color.Black;

                s = "I = " + Convert.ToString(n);
                size = DataForm.GBitmap.MeasureString(s, font);
                DataForm.GBitmap.DrawString(s, font, Brushes.Black, Elements[n].X - size.Height / 2, 80);
            }
            if (m != -1)
            {
                pen.Color = Color.Red;

                s = "J = " + Convert.ToString(m);
                size = DataForm.GBitmap.MeasureString(s, font);
                DataForm.GBitmap.DrawString(s, font, Brushes.Black, Elements[m].X - size.Height / 2, 100);
            }
            DataForm.GScreen.DrawImage(DataForm.Bitmap, DataForm.ClientRectangle);
        }
    }
}