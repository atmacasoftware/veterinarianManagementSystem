PGDMP  '    #                |            veterinarian    15.6    16.2 M    F           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            G           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            H           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            I           1262    16517    veterinarian    DATABASE     �   CREATE DATABASE veterinarian WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Turkish_T�rkiye.1254';
    DROP DATABASE veterinarian;
                postgres    false            �            1259    19231    animals    TABLE     Z  CREATE TABLE public.animals (
    animal_id bigint NOT NULL,
    breed character varying(100) NOT NULL,
    colour character varying(50) NOT NULL,
    date_of_birth date NOT NULL,
    gender character varying(20) NOT NULL,
    name character varying(100) NOT NULL,
    species character varying(100) NOT NULL,
    customer_id integer NOT NULL
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    19229    animals_animal_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.animals_animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.animals_animal_id_seq;
       public          postgres    false    216            J           0    0    animals_animal_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.animals_animal_id_seq OWNED BY public.animals.animal_id;
          public          postgres    false    214            �            1259    19230    animals_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.animals_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.animals_customer_id_seq;
       public          postgres    false    216            K           0    0    animals_customer_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.animals_customer_id_seq OWNED BY public.animals.customer_id;
          public          postgres    false    215            �            1259    19239    appointmensts    TABLE     �   CREATE TABLE public.appointmensts (
    appoinment_id integer NOT NULL,
    appoinment_date timestamp(6) without time zone NOT NULL,
    doctor_id integer NOT NULL,
    animal_id integer NOT NULL,
    customer_id integer NOT NULL
);
 !   DROP TABLE public.appointmensts;
       public         heap    postgres    false            �            1259    19335    appointmensts_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointmensts_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.appointmensts_animal_id_seq;
       public          postgres    false    218            L           0    0    appointmensts_animal_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.appointmensts_animal_id_seq OWNED BY public.appointmensts.animal_id;
          public          postgres    false    230            �            1259    19238    appointmensts_appoinment_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointmensts_appoinment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.appointmensts_appoinment_id_seq;
       public          postgres    false    218            M           0    0    appointmensts_appoinment_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.appointmensts_appoinment_id_seq OWNED BY public.appointmensts.appoinment_id;
          public          postgres    false    217            �            1259    19341    appointmensts_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointmensts_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.appointmensts_customer_id_seq;
       public          postgres    false    218            N           0    0    appointmensts_customer_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.appointmensts_customer_id_seq OWNED BY public.appointmensts.customer_id;
          public          postgres    false    231            �            1259    19324    appointmensts_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointmensts_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.appointmensts_doctor_id_seq;
       public          postgres    false    218            O           0    0    appointmensts_doctor_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.appointmensts_doctor_id_seq OWNED BY public.appointmensts.doctor_id;
          public          postgres    false    229            �            1259    19247    available_dates    TABLE     �   CREATE TABLE public.available_dates (
    available_date_id integer NOT NULL,
    available_date date NOT NULL,
    doctor_id integer NOT NULL
);
 #   DROP TABLE public.available_dates;
       public         heap    postgres    false            �            1259    19245 %   available_dates_available_date_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_dates_available_date_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public.available_dates_available_date_id_seq;
       public          postgres    false    221            P           0    0 %   available_dates_available_date_id_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE public.available_dates_available_date_id_seq OWNED BY public.available_dates.available_date_id;
          public          postgres    false    219            �            1259    19246    available_dates_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_dates_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.available_dates_doctor_id_seq;
       public          postgres    false    221            Q           0    0    available_dates_doctor_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.available_dates_doctor_id_seq OWNED BY public.available_dates.doctor_id;
          public          postgres    false    220            �            1259    19255 	   customers    TABLE     
  CREATE TABLE public.customers (
    customer_id bigint NOT NULL,
    address character varying(255),
    city character varying(50),
    mail character varying(255) NOT NULL,
    full_name character varying(100) NOT NULL,
    phone character varying(11) NOT NULL
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    19254    customers_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.customers_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.customers_customer_id_seq;
       public          postgres    false    223            R           0    0    customers_customer_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.customers_customer_id_seq OWNED BY public.customers.customer_id;
          public          postgres    false    222            �            1259    19264    doctors    TABLE       CREATE TABLE public.doctors (
    doctor_id bigint NOT NULL,
    address character varying(255) NOT NULL,
    city character varying(255) NOT NULL,
    mail character varying(255) NOT NULL,
    full_name character varying(100) NOT NULL,
    phone character varying(11) NOT NULL
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    19263    doctors_doctor_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.doctors_doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.doctors_doctor_id_seq;
       public          postgres    false    225            S           0    0    doctors_doctor_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.doctors_doctor_id_seq OWNED BY public.doctors.doctor_id;
          public          postgres    false    224            �            1259    19273    vaccines    TABLE     	  CREATE TABLE public.vaccines (
    vaccine_id integer NOT NULL,
    code character varying(100) NOT NULL,
    name character varying(100) NOT NULL,
    protection_finish_date date NOT NULL,
    protection_start_date date NOT NULL,
    animal_id integer NOT NULL
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    19313    vaccines_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.vaccines_animal_id_seq;
       public          postgres    false    227            T           0    0    vaccines_animal_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.vaccines_animal_id_seq OWNED BY public.vaccines.animal_id;
          public          postgres    false    228            �            1259    19272    vaccines_vaccine_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_vaccine_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.vaccines_vaccine_id_seq;
       public          postgres    false    227            U           0    0    vaccines_vaccine_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.vaccines_vaccine_id_seq OWNED BY public.vaccines.vaccine_id;
          public          postgres    false    226            �           2604    19234    animals animal_id    DEFAULT     v   ALTER TABLE ONLY public.animals ALTER COLUMN animal_id SET DEFAULT nextval('public.animals_animal_id_seq'::regclass);
 @   ALTER TABLE public.animals ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    216    214    216            �           2604    19235    animals customer_id    DEFAULT     z   ALTER TABLE ONLY public.animals ALTER COLUMN customer_id SET DEFAULT nextval('public.animals_customer_id_seq'::regclass);
 B   ALTER TABLE public.animals ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    216    215    216            �           2604    19242    appointmensts appoinment_id    DEFAULT     �   ALTER TABLE ONLY public.appointmensts ALTER COLUMN appoinment_id SET DEFAULT nextval('public.appointmensts_appoinment_id_seq'::regclass);
 J   ALTER TABLE public.appointmensts ALTER COLUMN appoinment_id DROP DEFAULT;
       public          postgres    false    218    217    218            �           2604    19325    appointmensts doctor_id    DEFAULT     �   ALTER TABLE ONLY public.appointmensts ALTER COLUMN doctor_id SET DEFAULT nextval('public.appointmensts_doctor_id_seq'::regclass);
 F   ALTER TABLE public.appointmensts ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    229    218            �           2604    19336    appointmensts animal_id    DEFAULT     �   ALTER TABLE ONLY public.appointmensts ALTER COLUMN animal_id SET DEFAULT nextval('public.appointmensts_animal_id_seq'::regclass);
 F   ALTER TABLE public.appointmensts ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    230    218            �           2604    19342    appointmensts customer_id    DEFAULT     �   ALTER TABLE ONLY public.appointmensts ALTER COLUMN customer_id SET DEFAULT nextval('public.appointmensts_customer_id_seq'::regclass);
 H   ALTER TABLE public.appointmensts ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    231    218            �           2604    19250 !   available_dates available_date_id    DEFAULT     �   ALTER TABLE ONLY public.available_dates ALTER COLUMN available_date_id SET DEFAULT nextval('public.available_dates_available_date_id_seq'::regclass);
 P   ALTER TABLE public.available_dates ALTER COLUMN available_date_id DROP DEFAULT;
       public          postgres    false    219    221    221            �           2604    19251    available_dates doctor_id    DEFAULT     �   ALTER TABLE ONLY public.available_dates ALTER COLUMN doctor_id SET DEFAULT nextval('public.available_dates_doctor_id_seq'::regclass);
 H   ALTER TABLE public.available_dates ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    221    220    221            �           2604    19258    customers customer_id    DEFAULT     ~   ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET DEFAULT nextval('public.customers_customer_id_seq'::regclass);
 D   ALTER TABLE public.customers ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    223    222    223            �           2604    19267    doctors doctor_id    DEFAULT     v   ALTER TABLE ONLY public.doctors ALTER COLUMN doctor_id SET DEFAULT nextval('public.doctors_doctor_id_seq'::regclass);
 @   ALTER TABLE public.doctors ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    224    225    225            �           2604    19276    vaccines vaccine_id    DEFAULT     z   ALTER TABLE ONLY public.vaccines ALTER COLUMN vaccine_id SET DEFAULT nextval('public.vaccines_vaccine_id_seq'::regclass);
 B   ALTER TABLE public.vaccines ALTER COLUMN vaccine_id DROP DEFAULT;
       public          postgres    false    226    227    227            �           2604    19314    vaccines animal_id    DEFAULT     x   ALTER TABLE ONLY public.vaccines ALTER COLUMN animal_id SET DEFAULT nextval('public.vaccines_animal_id_seq'::regclass);
 A   ALTER TABLE public.vaccines ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    228    227            4          0    19231    animals 
   TABLE DATA           n   COPY public.animals (animal_id, breed, colour, date_of_birth, gender, name, species, customer_id) FROM stdin;
    public          postgres    false    216   �]       6          0    19239    appointmensts 
   TABLE DATA           j   COPY public.appointmensts (appoinment_id, appoinment_date, doctor_id, animal_id, customer_id) FROM stdin;
    public          postgres    false    218   _       9          0    19247    available_dates 
   TABLE DATA           W   COPY public.available_dates (available_date_id, available_date, doctor_id) FROM stdin;
    public          postgres    false    221   �_       ;          0    19255 	   customers 
   TABLE DATA           W   COPY public.customers (customer_id, address, city, mail, full_name, phone) FROM stdin;
    public          postgres    false    223   �`       =          0    19264    doctors 
   TABLE DATA           S   COPY public.doctors (doctor_id, address, city, mail, full_name, phone) FROM stdin;
    public          postgres    false    225   �c       ?          0    19273    vaccines 
   TABLE DATA           t   COPY public.vaccines (vaccine_id, code, name, protection_finish_date, protection_start_date, animal_id) FROM stdin;
    public          postgres    false    227   �e       V           0    0    animals_animal_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.animals_animal_id_seq', 18, true);
          public          postgres    false    214            W           0    0    animals_customer_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.animals_customer_id_seq', 1, false);
          public          postgres    false    215            X           0    0    appointmensts_animal_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.appointmensts_animal_id_seq', 4, true);
          public          postgres    false    230            Y           0    0    appointmensts_appoinment_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.appointmensts_appoinment_id_seq', 13, true);
          public          postgres    false    217            Z           0    0    appointmensts_customer_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.appointmensts_customer_id_seq', 4, true);
          public          postgres    false    231            [           0    0    appointmensts_doctor_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.appointmensts_doctor_id_seq', 1, false);
          public          postgres    false    229            \           0    0 %   available_dates_available_date_id_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public.available_dates_available_date_id_seq', 59, true);
          public          postgres    false    219            ]           0    0    available_dates_doctor_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.available_dates_doctor_id_seq', 1, false);
          public          postgres    false    220            ^           0    0    customers_customer_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.customers_customer_id_seq', 13, true);
          public          postgres    false    222            _           0    0    doctors_doctor_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.doctors_doctor_id_seq', 8, true);
          public          postgres    false    224            `           0    0    vaccines_animal_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.vaccines_animal_id_seq', 1, false);
          public          postgres    false    228            a           0    0    vaccines_vaccine_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.vaccines_vaccine_id_seq', 15, true);
          public          postgres    false    226            �           2606    19237    animals animals_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (animal_id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    216            �           2606    19244     appointmensts appointmensts_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.appointmensts
    ADD CONSTRAINT appointmensts_pkey PRIMARY KEY (appoinment_id);
 J   ALTER TABLE ONLY public.appointmensts DROP CONSTRAINT appointmensts_pkey;
       public            postgres    false    218            �           2606    19253 $   available_dates available_dates_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT available_dates_pkey PRIMARY KEY (available_date_id);
 N   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT available_dates_pkey;
       public            postgres    false    221            �           2606    19262    customers customers_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    223            �           2606    19271    doctors doctors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (doctor_id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    225            �           2606    19280 $   doctors uk_eibxrh7nk6dkhc6c3i7pr80av 
   CONSTRAINT     _   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT uk_eibxrh7nk6dkhc6c3i7pr80av UNIQUE (mail);
 N   ALTER TABLE ONLY public.doctors DROP CONSTRAINT uk_eibxrh7nk6dkhc6c3i7pr80av;
       public            postgres    false    225            �           2606    19278    vaccines vaccines_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (vaccine_id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    227            �           2606    19281 #   animals fkb36lt3kj4mrbdx5btxmp4j60n    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n;
       public          postgres    false    3223    223    216            �           2606    19319 $   vaccines fkeasdy15b2kp5j4k13x2dfudqs    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs FOREIGN KEY (animal_id) REFERENCES public.animals(animal_id);
 N   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs;
       public          postgres    false    3217    216    227            �           2606    19330 )   appointmensts fkmrmcdiniq2nv095c3vn0tmc9s    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointmensts
    ADD CONSTRAINT fkmrmcdiniq2nv095c3vn0tmc9s FOREIGN KEY (doctor_id) REFERENCES public.doctors(doctor_id);
 S   ALTER TABLE ONLY public.appointmensts DROP CONSTRAINT fkmrmcdiniq2nv095c3vn0tmc9s;
       public          postgres    false    225    218    3225            �           2606    19347 )   appointmensts fkmukm0s7nam7lf693ytm1ynkkq    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointmensts
    ADD CONSTRAINT fkmukm0s7nam7lf693ytm1ynkkq FOREIGN KEY (animal_id) REFERENCES public.animals(animal_id);
 S   ALTER TABLE ONLY public.appointmensts DROP CONSTRAINT fkmukm0s7nam7lf693ytm1ynkkq;
       public          postgres    false    216    218    3217            �           2606    19286 +   available_dates fknb419ilm71d71rm584rk460pk    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT fknb419ilm71d71rm584rk460pk FOREIGN KEY (doctor_id) REFERENCES public.doctors(doctor_id);
 U   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT fknb419ilm71d71rm584rk460pk;
       public          postgres    false    3225    225    221            �           2606    19352 )   appointmensts fktfxt5x1ui2yadyckvic4x051u    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointmensts
    ADD CONSTRAINT fktfxt5x1ui2yadyckvic4x051u FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id);
 S   ALTER TABLE ONLY public.appointmensts DROP CONSTRAINT fktfxt5x1ui2yadyckvic4x051u;
       public          postgres    false    3223    218    223            4   �  x�eSAn�0<ۯ�\�NBµ-	!!�S��Һ�
d$x9s�H��u�.�b����l�����ɥd<`"$�����\��%%������1�����ty��iy"c���9���`�;]/�d�vH}2ة���Rz]K��4��K�4h��).�1�14����`�
-iϡ��Q���3.�e��kĭ��2�O�Z͋�á�2)�xX�I]ާQʭr��mΥG��	�O�Iި(�*���<��\eO�<�H����[�-q�m\I�V7[^9p���tzC���v��V�?��|']e^��3�k�VB�M�m�X�CEQ�t�%�N�gl4�'H��T��ԡ�Gm��j���V�]������J�3Q���oC�b��O��|���U�@�E������/��#ѣ�ϔ�?7�U      6   e   x�U���0�3TA�f��O-鿎�j��"��4@��{C6��_�����݈����ʀ�Xr�,�9-K���ƘZ�eW�����C8�xq>�{o��6"t      9   �   x�U��m1D�s3�6�MK.�.�t|@C�IA�ذxG��knЛ�/m��Tp6\Mw3��LPG{��]]�aVa�eVe�i^i�m^m:9�D�Û����&68V�a�~8�N�'�Ë������?�v��hW�+�ō���σ��'���������燯�u�k��}���a����}����������Û��?%���S�>K�y��_8�<�z[�z��<�ý[>?"�q���      ;   �  x�ESKr�6]7O�� �mkR���R��Tٴȶ���ȖW�F1U�Cr�9ɴ(��Px�����\Y#�qZ����V��?1��eh͑���3������G����5�n�=�p7��h��N�	쐓� ��f�BrG�Α�Y�MS�u�h%��Z������`K���:��'�d��ѥc��rc��b�lK�v��모��Z��ɒ�z�|�r�6�	�S��,�Q����w���Xk���tU5������,��;��6	n��av�Z����
�U>�U�:���1�US����J��u'˲�c�6���.G����|8PX�=��ɐ�^@�����Z�uт�p�EޜE���7�?�.����U��C�3��_葜x���C�t���K�T��bz�~�,6�)��Ǒ���X��D�"���@�h8�fy�C�֪х�V�/�������gc���5}Ly4��G|�u�8H�1�nT�%�Mu����ę����'���ӿ�0����)��>�m2p����=� \�\��c�P
ZVy�_-G���f�����9 WGv"������.�D���|DK\ڧ� �Q4���̻���}���|>��#��U�̛w��1�|��^9�/~�p�U)UY�u�*��ĕs�w!b8�^g�?�H�fR�e��#�Ў����\*ɣ�����UQ? ��J3      =   �  x�=QK��0[?N�Pc;�t>��LWzjV�<�c�LY��^N���%��'��Y�H�SJ�﫝Sxr���E��L6J��]�}CI{( �E.��4I���Vh�E�O��~E7Z݀�)3k�f�v�2z��W8ٮ�����1΋��*� �S��e��񾭟�m�M����m����NG���LF뤀��9���Y7�g��e���/�fmoy3�-�n�wh��B�2Z	��%��䣵��*rN� �iS?640=k����u�3�*�FY�XYSZ1�(*A�ic�NҌ����*]���_�H���:�d���B&
V�X��I	�'��|�8���j�v;v�ϯ�~V;��^����4F�NhL,ۿD��+X��URA��'DO.�=\�)����í�v3C��6=��Mr=H�
*DIƲ�k�$�_F���      ?   �   x��б1�ڞ�����8JjV��DG}�0;�^$Qtw�����/?��RJ:�����1�$����M�A}qBʱ:mN�Ϋ��ln�,.ᡓ����NƵ3Ηo�����P�$�N�s8
t�M��7粖�ט՘�0�e��gT_Z     