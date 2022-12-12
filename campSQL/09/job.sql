USE [campDB]
GO

/****** Object:  Table [dbo].[job]    Script Date: 2022/12/12 ¤W¤È 10:01:37 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[job](
	[uID] [int] NOT NULL,
	[rackID] [int] NOT NULL,
	[job] [nvarchar](20) NULL,
	[salary] [nvarchar](20) NULL,
	[quantity] [int] NULL,
	[place] [nvarchar](50) NULL,
	[time] [nvarchar](50) NULL,
	[date] [nvarchar](50) NULL,
	[img] [varbinary](max) NULL,
	[remark] [nvarchar](50) NULL,
	[rackUp] [datetime2](7) NULL,
	[rackDown] [datetime2](7) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO


