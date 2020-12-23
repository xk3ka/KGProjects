using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Implementation05
{
    public class Element
    {
        public int X;
        public int Y;
        public int Value;
        public Color Color;

        public Element(int x, int y, int value, Color color)
        {
            X = x;
            Y = y;
            Value = value;
            Color = color;
        }
    }
}
