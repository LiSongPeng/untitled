void FuncT(int iNum,char** asIP)
{
   for(int i=0;i<iNum;i++)
   {
    printf("%s\n",asIP+i);
   }
}
int main(int
argc,char argv[])
{
       char asIP[20][16];
       strcpy(asIP+0,"172.2.2.1");
       strcpy(asIP+1,"172.23.3.2");
       FuncT(2,asIP);
       exit(0);
}
