PGDMP                          |            insan_kaynaklari_ys    14.12    14.12     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    57663    insan_kaynaklari_ys    DATABASE     q   CREATE DATABASE insan_kaynaklari_ys WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_T�rkiye.1254';
 #   DROP DATABASE insan_kaynaklari_ys;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            �            1259    57802 	   candidate    TABLE     [  CREATE TABLE public.candidate (
    id integer NOT NULL,
    notice_period date NOT NULL,
    military_status character varying(10) NOT NULL,
    phone character varying(10) NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    cv character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    "position" character varying(50) NOT NULL,
    CONSTRAINT candidate_military_status_check CHECK (((military_status)::text = ANY ((ARRAY['TAMAMLANDI'::character varying, 'MUAF'::character varying, 'TECILLI'::character varying])::text[])))
);
    DROP TABLE public.candidate;
       public         heap    postgres    false    3            �            1259    57801    candidate_id_seq    SEQUENCE     �   ALTER TABLE public.candidate ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.candidate_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210    3            �          0    57802 	   candidate 
   TABLE DATA           |   COPY public.candidate (id, notice_period, military_status, phone, first_name, last_name, cv, email, "position") FROM stdin;
    public          postgres    false    210   6       �           0    0    candidate_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.candidate_id_seq', 10, true);
          public          postgres    false    209            ^           2606    57807    candidate candidate_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.candidate
    ADD CONSTRAINT candidate_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.candidate DROP CONSTRAINT candidate_pkey;
       public            postgres    false    210            �   �  x�m��r�0���)�dl|� ��=z�LGq,�YJ��@�c�<C�{U
ER?��vg~�w�@R� NI���|��C��C�
^`�"C`���]�[*��·����u-,���N%F|F�=�$��ck�1T_��.P���-[����G���b��NK�=B�� ���fT��~<���!ll˳��Zl��iJ&1�ʪ���<d�躖�җ ���6<:_���R�(�,l&M��3��N@��&P30��PE�i�$7��䥡����U�9�P�} �po���B�VRUw��~�(��i�#�F�������ȴ��.��m-��~��ܽ��,��xh`��yJ^C����Ls-eM�
�
�C�p��T�������Q ���n9"�X!�����|�����lꏦ��-Y��!�zA����     