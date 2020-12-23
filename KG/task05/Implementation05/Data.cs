using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Implementation05
{
    public class Data
    {
        public Graphics GBitmap { get; set; }

        public Graphics GScreen { get; set; }

        public Bitmap Bitmap { get; set; }

        public Rectangle ClientRectangle { get; set; }

        public Data( Graphics gbitmap, Graphics gscreen, Bitmap bitmap, Rectangle clientRectangle)
        {
            GBitmap = gbitmap;
            GScreen = gscreen;
            Bitmap = bitmap;
            ClientRectangle = clientRectangle;
        }
    }
}
